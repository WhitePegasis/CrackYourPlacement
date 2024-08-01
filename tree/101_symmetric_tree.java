//https://leetcode.com/problems/symmetric-tree/submissions/1341013532/
package tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
   private boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
       if(leftRoot==null && rightRoot==null) return true;
       if(leftRoot==null || rightRoot==null) return false;

       if(leftRoot.val != rightRoot.val) return false;

       return isSymmetric(leftRoot.left, rightRoot.right) && isSymmetric(rightRoot.left, leftRoot.right);
       
   }
   public boolean isSymmetric(TreeNode root) {
       return isSymmetric(root.left,root.right);
   }
}
