//https://www.geeksforgeeks.org/problems/largest-bst/1
package tree;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}


class Solution {

    static int[] helper(Node node) {
        // {Current BST size, smallest node val, largest node val} 
        if (node == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] resLeft = helper(node.left);
        int[] resRight = helper(node.right);  // Corrected to node.right

        // Check if the current node forms a BST with its left and right subtrees
        if (node.data > resLeft[2] && node.data < resRight[1]) {
            // Return the size of the BST, smallest value, and largest value
            return new int[]{1 + resLeft[0] + resRight[0], Math.min(node.data, resLeft[1]), Math.max(node.data, resRight[2])};
        }

        // If it's not a BST, return the size of the largest BST found in the subtrees
        return new int[]{Math.max(resLeft[0], resRight[0]), Integer.MIN_VALUE, Integer.MAX_VALUE};
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        int[] res = helper(root);
        return res[0];
    }
}
