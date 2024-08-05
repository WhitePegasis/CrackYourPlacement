//https://leetcode.com/problems/binary-tree-paths/description/
package tree;

import java.util.*;

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
    private void dfs(TreeNode node, String currPath, List<String> ans) {
        if (node.left == null && node.right == null)
            ans.add(currPath + node.val);

        if (node.left != null)
            dfs(node.left, currPath + node.val + "->", ans);
        if (node.right != null)
            dfs(node.right, currPath + node.val + "->", ans);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();

        if (root != null)
            dfs(root, "", ans);

        return ans;
    }
}