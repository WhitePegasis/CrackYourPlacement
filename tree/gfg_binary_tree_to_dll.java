//https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1
package tree;

import java.util.*;

class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        ArrayList<Integer> list= new ArrayList<>();
        
        getData(root,list);
        Node head=null;
        Node temp=null;
        for(int i=0;i<list.size();i++){
            Node  temp2= new Node(list.get(i));
            if(head==null){
               head=temp2;
               temp=head;
            }else{
               temp.right=temp2;
               temp2.left=temp;
               
               temp=temp2;
            }
        }
        return head;
    
    }
    
    void getData(Node root,ArrayList<Integer> list){
        
        if(root==null){
            return;
        }
        getData(root.left,list);
        list.add(root.data);
        getData(root.right,list);
    }
}
