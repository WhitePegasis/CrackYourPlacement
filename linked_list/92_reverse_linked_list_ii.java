//https://leetcode.com/problems/reverse-linked-list-ii/submissions/1342059398/
package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0), pre = dummy, cur;
        dummy.next = head;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = temp;
        }
        return dummy.next;
    }
}
