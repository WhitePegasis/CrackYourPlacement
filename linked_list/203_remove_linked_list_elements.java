//https://leetcode.com/problems/remove-linked-list-elements/

package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode helper(ListNode node, int val){
        if(node==null){
            return null;
        }

        ListNode nextNode = helper(node.next, val);

        if(node.val == val){
            return nextNode;
        }

        node.next = nextNode;
        return node;
    }
    public ListNode removeElements(ListNode head, int val) {
        return helper(head, val);
    }
}
