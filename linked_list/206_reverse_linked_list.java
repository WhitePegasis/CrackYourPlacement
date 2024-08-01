//https://leetcode.com/problems/reverse-linked-list/description/

package linked_list;


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || (head.next)==null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

}