//https://leetcode.com/problems/ones-and-zeroes/
package dynamic_programming;

class Solution {
    // Helper method to count the number of '0's in a string
    private int countZero(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                count++;
            }
        }
        return count;
    }

    // Recursive helper method with memoization
    private int helper(String[] strs, int m, int n, int idx, int[][][] dp) {
        if (idx < 0) {
            return 0;
        }
        if (dp[m][n][idx] != -1) {
            return dp[m][n][idx];
        }

        int zero = countZero(strs[idx]);
        int one = strs[idx].length() - zero;

        int ans1 = 0;

        // Case when we include the current string if possible
        if (m >= zero && n >= one) {
            ans1 = helper(strs, m - zero, n - one, idx - 1, dp) + 1;
        }

        // Case when we exclude the current string
        dp[m][n][idx] = Math.max(ans1, helper(strs, m, n, idx - 1, dp));
        return dp[m][n][idx];
    }

    // Main method to find the maximum number of strings that can be formed with m 0's and n 1's
    public int findMaxForm(String[] strs, int m, int n) {
        int p = strs.length - 1;
        int[][][] dp = new int[m + 1][n + 1][p + 1];

        // Initialize the dp array with -1
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= p; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // Call the helper function to get the result
        return helper(strs, m, n, p, dp);
    }
}
