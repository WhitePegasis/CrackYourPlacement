//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
package tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    TreeNode prev=null;

    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        
        helper(root.right);
        helper(root.left);
        
        root.right=prev;
        root.left=null;
        prev=root;
    }
    public void flatten(TreeNode root) {
        helper(root);
    }
}
