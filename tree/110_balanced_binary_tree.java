//https://leetcode.com/problems/balanced-binary-tree/
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
    public boolean isBalanced(TreeNode root) {
        if (helper(root) == -1)
            return false;
        return true;
    }

    private int helper(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = helper(root.left);
        int rightHight = helper(root.right);

        if (leftHeight == -1 || rightHight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHight) > 1)
            return -1;

        return Math.max(leftHeight, rightHight) + 1;
    }
}
