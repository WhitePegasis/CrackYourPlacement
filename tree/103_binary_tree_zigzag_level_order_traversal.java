//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null)
            return ans;
        
        boolean leftToRight=true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp = new ArrayList<>(Collections.nCopies(size, 0));

            for(int i=0;i<size;i++){
                TreeNode currNode=q.poll();
                
                int idx=leftToRight?i:size-i-1;
                temp.set(idx, currNode.val);
                
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
                
            }

            leftToRight=!leftToRight;
            ans.add(temp);

        }
       return ans; 
    }
}
