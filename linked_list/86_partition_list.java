//https://leetcode.com/problems/partition-list/
package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0), right = new ListNode(0);
        ListNode l = left, r = right;

        while(head != null){
            if(head.val<x){
                l.next = head;
                l = l.next;
            }
            else{
                r.next = head;
                r = r.next;
            }

            head = head.next;
        }
        l.next = right.next;
        r.next = null;
        return left.next;
    }
}
