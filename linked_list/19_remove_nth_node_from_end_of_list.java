//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
package linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    int getLength(ListNode node){
        
        int len=0;
        
        while(node!=null){
            node=node.next;
            len++;
        }
        
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=getLength(head);
        
        if(n==len){
            return head.next;
        }
        
        int distFromBeg=len-n;
        
        ListNode node=head;
        
        for(int i=0;i<distFromBeg-1;i++){
            node=node.next;
        }   
        
        if(node.next.next == null)
            node.next=null;
        else
            node.next=node.next.next;
        
        return head;
    }
}
