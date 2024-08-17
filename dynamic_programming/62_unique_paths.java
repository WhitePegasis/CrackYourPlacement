//https://leetcode.com/problems/unique-paths/
package dynamic_programming;

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        return CountPath(0, 0, m - 1, n - 1, dp);
    }

    public static int CountPath(int i, int j, int r, int c, int[][] dp) {
        if (i > r || j > c) {
            return 0;
        }
        if (i == r && j == c) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Move right
        int a = CountPath(i, j + 1, r, c, dp);
        // Move Down
        int b = CountPath(i + 1, j, r, c, dp);
        return dp[i][j] = a + b;
    }
}
