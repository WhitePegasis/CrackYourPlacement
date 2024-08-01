//https://leetcode.com/problems/palindrome-linked-list/description/
package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        // Steps to follow:
        // 1_) Find the middle element
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2_) if the no of nodes are odd then move slow to one point
        if(fast != null && fast.next == null){
            slow = slow.next;
        }
        //3_) Reverse the end half
        ListNode prev = null;
        ListNode temp = null;
        while(slow != null && slow.next != null){
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        if(slow != null){
            slow.next = prev;
        }
        //4_) Compare the start half and end half if found any inequality then return false otherwise return true.
        fast = head;
        while(slow!=null && fast!=null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}