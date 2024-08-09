//https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int currLevelSize = q.size();

            for(int i=0; i<currLevelSize; i++){
                TreeNode currNode = q.poll();
                temp.add(currNode.val);

                if(currNode.left!=null){
                    q.add(currNode.left);
                }

                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            ans.add(temp);
        }

        return ans;
    }
}
