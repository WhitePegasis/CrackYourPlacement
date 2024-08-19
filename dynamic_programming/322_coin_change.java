//https://leetcode.com/problems/coin-change/
package dynamic_programming;

import java.util.*;

class Solution {
    private static final int INFINITY = 100000;  // Large number to simulate infinity

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Initialize dp array with -1 (indicating uncomputed values)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = coinChangeHelper(coins, n, amount, dp);

        // If result is greater than or equal to INFINITY, return -1 (no solution found)
        return result >= INFINITY ? -1 : result;
    }

    private int coinChangeHelper(int[] coins, int n, int amount, int[][] dp) {
        // Base case: If amount is zero, no coins are needed
        if (amount == 0) {
            return 0;
        }
        
        // Base case: If no coins left, return a large number (simulating infinity)
        if (n == 0) {
            return INFINITY;
        }

        // Return cached result if it's already computed
        if (dp[n][amount] != -1) {
            return dp[n][amount];
        }

        // Don't take the current coin
        int notTake = coinChangeHelper(coins, n - 1, amount, dp);

        // Take the current coin (if it's less than or equal to the amount)
        int take = INFINITY;
        if (coins[n - 1] <= amount) {
            take = coinChangeHelper(coins, n, amount - coins[n - 1], dp) + 1;
        }

        // Store and return the minimum of both options
        dp[n][amount] = Math.min(take, notTake);
        return dp[n][amount];
    }
}
