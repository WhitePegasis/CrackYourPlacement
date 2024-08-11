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
    public int numTrees(int n) {
        int[] dp = new int[n+1];

        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }

        return helper(n, dp);
    }

    private int helper(int n, int[] dp){
        if(n<=1) return 1;

        if(dp[n] != -1) return dp[n];

        int ans = 0;

        for(int i=1; i<=n; i++){
            ans += helper(i-1, dp) * helper(n-i,dp);
        }

        return dp[n] = ans;
    } 
}
