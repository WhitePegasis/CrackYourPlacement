//https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
package linked_list;

class Node {
    int data;
    Node next;
    Node bottom;
 
   Node(int data) {
       this.data = data;
       next = null;
       bottom = null;
   }
 }

class Solution {
    
    // Merges two linked lists in a particular
    // order based on the data value
    Node merge(Node list1, Node list2) {
        // Create a dummy node as a
        // placeholder for the result
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        // Merge the lists based on data values
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        // Connect the remaining
        // elements if any
        if (list1 != null) {
            res.bottom = list1;
        } else {
            res.bottom = list2;
        }

        // Break the last node's
        // link to prevent cycles
        if (dummyNode.bottom != null) {
            dummyNode.bottom.next = null;
        }

        return dummyNode.bottom;
    }
    
    // Function to flatten a linked list
    Node flatten(Node head) {
        
        // If head is null or there
        // is no next node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the
        // rest of the linked list
        Node mergedHead = flatten(head.next);
        head = merge(head, mergedHead);
        return head;
    }
}