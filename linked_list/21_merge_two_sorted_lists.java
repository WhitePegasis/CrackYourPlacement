//https://leetcode.com/problems/merge-two-sorted-lists/
package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // If list1 is null, there is nothing to merge, so return list2.
        if(list1 == null) return list2;

        // If list2 is null, there is nothing to merge, so return list1.
        if(list2 == null) return list1;

        // If the value in list1 is less than the value in list2,
        // recursively merge the rest of list1 with list2.
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            // Return list1 as the head of the merged list.
            return list1;
        }
        else {
            // Otherwise, if the value in list2 is less than or equal to the value in list1,
            // recursively merge list1 with the rest of list2.
            list2.next = mergeTwoLists(list1, list2.next);
            // Return list2 as the head of the merged list.
            return list2;            
        }
    }

}