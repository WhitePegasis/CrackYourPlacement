//https://leetcode.com/problems/trapping-rain-water/
package dynamic_programming;

class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        
        int leftMax = 0, rightMax = 0;
        int sum = 0;
        
        // Two-pointer approach to calculate the trapped water
        while (i <= j) {
            if (height[i] <= height[j]) {
                // If the current height at the left pointer is greater than or equal to leftMax,
                // update leftMax, otherwise calculate the trapped water at the current position.
                if (height[i] >= leftMax) {
                    leftMax = height[i];
                } else {
                    sum += leftMax - height[i];
                }
                i++;  // Move the left pointer to the right
            } else {
                // If the current height at the right pointer is greater than rightMax,
                // update rightMax, otherwise calculate the trapped water at the current position.
                if (height[j] >= rightMax) {
                    rightMax = height[j];
                } else {
                    sum += rightMax - height[j];
                }
                j--;  // Move the right pointer to the left
            }
        }
        
        // Return the total amount of trapped water
        return sum;
    }
}

