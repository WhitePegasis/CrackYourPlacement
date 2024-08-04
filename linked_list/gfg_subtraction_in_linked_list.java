//https://www.geeksforgeeks.org/problems/subtraction-in-linked-list/1
package linked_list;

class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // Remove leading zeros from both linked lists
        head1 = removePrecedingZeros(head1);
        head2 = removePrecedingZeros(head2);
        
        // If both lists are empty, return a single node with 0
        if (head1 == null && head2 == null) {
            return new Node(0);
        }
        
        // If one of the lists is empty, return the other list
        if (head1 == null) {
            return head2;
        }
        
        if (head2 == null) {
            return head1;
        }
        
        // Get the lengths of both linked lists
        int len1 = length(head1);
        int len2 = length(head2);
        
        Node smallHead, bigHead;
        
        // Determine which list is larger (numerically)
        if (len1 > len2) {
            smallHead = head2;
            bigHead = head1;   
        } else if (len1 < len2) {
            smallHead = head1;
            bigHead = head2;
        } else {
            // If lengths are equal, compare the lists element-wise
            Node[] minMax = getMinMax(head1, head2);
            smallHead = minMax[0];
            bigHead = minMax[1];
        }
        
        // Subtract the smaller list from the larger list
        return subtract(bigHead, smallHead);
    }
    
    // This method returns an array with the smaller and larger of two lists
    private Node[] getMinMax(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node big = null;
        Node small = null;
        
        // Compare nodes element-wise to determine the larger and smaller lists
        while (temp1 != null && temp2 != null) {
            if (temp1.data > temp2.data) {
                big = temp1;
                small = temp2;
            } else if (temp1.data < temp2.data) {
                big = temp2;
                small = temp1;
            }
            if (big != null) {
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return new Node[]{small, big};
    }
    
    // This method performs the subtraction of two lists
    private Node subtract(Node big, Node small) {
        // Reverse both lists to simplify subtraction from least significant digit
        big = reverse(big);
        small = reverse(small);
        
        Node result = new Node(-1);
        Node current = result;
        boolean borrow = false;
        
        // Perform the subtraction digit by digit
        while (big != null) {
            // Get the current digit of big and small numbers (or 0 if null)
            int bigData = (big != null) ? big.data : 0;
            int smallData = (small != null) ? small.data : 0;
        
            // Adjust bigData if there was a borrow from the previous digit
            if (borrow) {
                if (bigData == 0) {
                    bigData = 9; // Borrow from higher place value
                } else {
                    bigData -= 1; // Subtract 1 and clear borrow
                    borrow = false;
                }
            }
        
            // Calculate the subtraction result of current digits
            int sub = bigData - smallData;
        
            // If result is negative, set borrow flag and adjust result
            if (sub < 0) {
                sub += 10; // Add 10 to handle borrow
                borrow = true; // Set borrow flag for next place value
            }
        
            // Create a new node with the subtraction result
            current.next = new Node(sub);
            current = current.next; // Move to the next node in result list
        
            // Move to next nodes in big and small lists if they exist
            if (big != null) big = big.next;
            if (small != null) small = small.next;
        }
        
        // Reverse the result to get the correct order
        result = reverse(result.next);
        result = removePrecedingZeros(result);
        
        return result==null? new Node(0) : result;
    }
    
    // Reverse a linked list
    private Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    // Calculate the length of a linked list
    private int length(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    
    // Remove leading zeros from a linked list
    private Node removePrecedingZeros(Node node) {
        while (node != null) {
            if (node.data != 0) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
