//https://leetcode.com/problems/maximum-width-of-binary-tree/

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


class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        q.offer(new Pair<TreeNode, Integer>(root, 0));

        //BFS traversal
        while(!q.isEmpty()){
            int currLevelSize = q.size();

            int firstIndex=-1, lastIndex = -1;

            for(int i=0; i<currLevelSize; i++){
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode node = p.first;
                Integer idx = p.second;

                if(i==0) firstIndex = idx;
                if(i==currLevelSize-1) lastIndex = idx;

                if(node.left != null) q.offer(new Pair<TreeNode, Integer>(node.left, 2*idx+1));
                if(node.right != null) q.offer(new Pair<TreeNode, Integer>(node.right, 2*idx+2));
            }

            ans = Math.max(ans, lastIndex-firstIndex+1);
        }

        return ans;
    }
}