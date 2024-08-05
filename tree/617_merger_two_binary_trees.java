//https://leetcode.com/problems/merge-two-binary-trees/

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
    private TreeNode helper(TreeNode node1, TreeNode node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        TreeNode node = new TreeNode(node1.val + node2.val);

        node.left = helper(node1.left, node2.left);
        node.right = helper(node1.right, node2.right);

        return node;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return helper(root1, root2);
    }
}