//https://www.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1

package linked_list;

class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}

class Solution
{
    Node compute(Node node)
    {
        if(node.next==null){
            return node;
        }
        
        Node nextNode=compute(node.next);
        
        if(node.data>=nextNode.data){
            node.next=nextNode;
            return node;
        }
        
        return nextNode;
    }
}
  