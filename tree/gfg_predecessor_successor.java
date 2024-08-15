//https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
package tree;

class Node
{
    int data;
    Node left, right;
    Node(int item)    {
        data = item;
        left = right = null;
    }
} 
class Solution {
    
    private static void findSuccessor(Node root, Node[] suc, int key){
        while(root!=null){
            if( root.data <= key ){
                root = root.right;
            }
            else{
                suc[0] = root;
                root = root.left;
            }
        }
    }
    private static void findPredecessor(Node root, Node[] pre, int key){
        while(root!=null){
            if( root.data >= key ){
                root = root.left;
            }
            else{
                pre[0] = root;
                root = root.right;
            }
        }
    }
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        
        findSuccessor(root, suc, key);
        findPredecessor(root, pre, key);
    }
}