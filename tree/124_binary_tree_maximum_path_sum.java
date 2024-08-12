//https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;

        helper(root, maxValue);
        return maxValue[0];
    }

    private int helper(TreeNode node, int[] maxValue){
        if(node == null) return 0;

        int left = helper(node.left, maxValue);
        int leftMax = Math.max(0, left);

        int right = helper(node.right, maxValue);
        int rightMax = Math.max(0, right);

        maxValue[0] = Math.max(maxValue[0], leftMax + rightMax + node.val);

        return Math.max(leftMax, rightMax) + node.val;
    }
}