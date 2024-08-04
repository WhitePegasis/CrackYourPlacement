//https://leetcode.com/problems/reverse-nodes-in-k-group/

package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    private ListNode reverseLinkedList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
    private ListNode getKthNode(ListNode node, int k){
        k--;

        while(node!=null && k>0){
            node=node.next;
            k--;
        }

        return node;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode kThNode = getKthNode(curr, k);

            if(kThNode == null){
                if(prev != null) prev.next = curr;
                break;
            }

            ListNode nextNode = kThNode.next;

            kThNode.next = null;

            reverseLinkedList(curr);

            if(curr==head) head = kThNode;
            else prev.next =kThNode;

            prev = curr;
            curr = nextNode;
        }

        return head;
    }
}