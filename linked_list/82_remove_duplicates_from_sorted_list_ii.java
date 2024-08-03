//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Special case...
        if (head == null || head.next == null)
            return head;
        // create a fake node that acts like a fake head of list pointing to the
        // original head and it points to the original head......
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode curr = fake;
        // Loop till curr.next and curr.next.next not null
        while (curr.next != null && curr.next.next != null) { 
            // curr.next means the next node of curr pointer and
            // curr.next.next means the next of next of curr pointer...
            // if the value of curr.next and curr.next.next is same...
            // There is a duplicate value present in the list...
            if (curr.next.val == curr.next.next.val) {
                int duplicate = curr.next.val;
                // If the next node of curr is not null and its value is eual to the duplicate
                // value...
                while (curr.next != null && curr.next.val == duplicate) {
                    // Skip those element and keep updating curr...
                    curr.next = curr.next.next;
                }
            }
            // Otherwise, move curr forward...
            else {
                curr = curr.next;
            }
        }
        return fake.next; // Return the linked list...
    }
}