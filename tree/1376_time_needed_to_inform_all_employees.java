//https://leetcode.com/problems/time-needed-to-inform-all-employees/
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
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        Arrays.setAll(adj, i -> new ArrayList<>());
        
        for(int i = 0; i < n; i++)
            if(manager[i] != -1)
                adj[manager[i]].add(i);

        return dfs(adj, headID, informTime);
    }

    private int dfs(List<Integer>[] adj, int root, int[] informTime) {
        int ans = 0;
        for(int node: adj[root])
            ans = Math.max(ans, dfs(adj, node, informTime));
        return ans + informTime[root];
    }
}
