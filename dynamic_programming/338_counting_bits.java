//https://leetcode.com/problems/counting-bits/
package dynamic_programming;

class Solution {
    public int[] countBits(int num) {
    
        int[] f = new int[num + 1];

        // Iterate through each number from 1 to `num`
        for (int i = 1; i <= num; i++) {
            // The key observation here is that the number of 1's in the binary representation
            // of `i` is equal to the number of 1's in the binary representation of `i >> 1`
            // (which is `i` divided by 2, or `i` shifted right by 1 bit) plus the last bit of `i`
            // (which is `1` if `i` is odd, and `0` if `i` is even).

            // `i >> 1` gives the number `i` divided by 2, effectively removing the least significant bit.
            // `i & 1` gives the value of the least significant bit (either 0 or 1).
            // Adding these two gives the number of 1's in the binary representation of `i`.
            f[i] = f[i >> 1] + (i & 1);
        }

        // Return the array `f`, where each element `f[i]` represents the number of 1's
        // in the binary representation of the integer `i`.
        return f;
    }

}
