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
    // Map for keeping track of (PrefixSum, timesPrefixSumSeen) during traversal
    Map<Long, Integer> preSum;
    int count;

    public int pathSum(TreeNode root, int targetSum) {
        preSum = new HashMap<>();
        count = 0;

        dfs(root, 0, targetSum);

        return count;
    }

    private void dfs(TreeNode root, long prefixSum, int targetSum) {
        // base case
        if (root == null) return;

        
        prefixSum += root.val;
        
        // If map contains a sum equal to (prefixSum - targetSum), we need to increment count that many times
        if (preSum.containsKey(prefixSum-targetSum)) {
            count += preSum.get(prefixSum-targetSum);
        } 
        
        // There can be cases when the prefixSum is directly equal to targetSum, we need to increment count
        if (targetSum == prefixSum) {
            count++;
        }

        // Update the prefixSum till current node and it's count
        preSum.put(prefixSum, preSum.getOrDefault(prefixSum, 0) + 1);

        // Recurse
        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);

        // Backtrack
        preSum.put(prefixSum, preSum.get(prefixSum) - 1);
        
    }
}
