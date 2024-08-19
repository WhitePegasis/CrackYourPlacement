//https://leetcode.com/problems/longest-increasing-subsequence/submissions/1360998233/
package dynamic_programming;

import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        for (int x : nums) {
            if (sub.isEmpty() || sub.get(sub.size() - 1) < x) {
                sub.add(x);
            } else {
                int index = Collections.binarySearch(sub, x); // Find the position of the smallest number >= x
                if (index < 0) {
                    index = -(index + 1); // Adjust the index when element is not found
                }
                sub.set(index, x); // Replace the number at that index with x
            }
        }
        return sub.size();
    }
}