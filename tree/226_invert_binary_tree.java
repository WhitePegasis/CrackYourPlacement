//https://leetcode.com/problems/invert-binary-tree/description/
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
    public TreeNode invertTree(TreeNode node) {
        if(node == null) return null;

        TreeNode leftNode = invertTree(node.left);
        TreeNode rightNode = invertTree(node.right);

        node.left = rightNode;
        node.right = leftNode;

        return node;
    }
}