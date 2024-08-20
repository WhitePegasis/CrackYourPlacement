//https://leetcode.com/problems/decode-ways/
package dynamic_programming;

import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return topDownDecode(s, 0, dp);
    }

    private int topDownDecode(String s, int index, int[] dp) {
        // Base case: if the index reaches the end of the string
        if (index == s.length()) {
            return 1; // This is a valid decoding
        }

        // Check memoization table
        if (dp[index] != -1) {
            return dp[index];
        }

        // Check for leading zero
        if (s.charAt(index) == '0') {
            return 0; // This decoding is invalid
        }

        // Decode single digit
        int ways = topDownDecode(s, index + 1, dp);

        // Decode two digits if possible
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += topDownDecode(s, index + 2, dp);
        }

        // Memoize the result
        dp[index] = ways;

        return ways;
    }
}