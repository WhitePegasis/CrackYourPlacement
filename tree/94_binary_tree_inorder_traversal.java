package tree;

import java.util.*;

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
    void morris(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        
        morris(root.left,ans);
        ans.add(root.val);
        morris(root.right,ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        morris(root,ans);
        return ans;
    }
}