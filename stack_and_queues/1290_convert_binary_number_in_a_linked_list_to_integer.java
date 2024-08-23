//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
package stack_and_queues;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int getDecimalValue(ListNode head) {     
        int ans = 0;
        for(ListNode temp =  head;temp!=null;temp=temp.next){
            ans =  (ans<<1)+temp.val;
        }                
        return ans;        
    }
}
