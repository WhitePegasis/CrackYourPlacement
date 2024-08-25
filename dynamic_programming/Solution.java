//https://leetcode.com/problems/frog-jump/
package dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Solution {
    // HashMap to keep track of valid stone positions
    HashMap<Integer, Boolean> mp = new HashMap<>();

    // Recursive method with memoization to determine if the frog can reach the last stone
    public boolean recursion(int pos, int prevStep, List<Integer> stones, int n, Map<String, Boolean> memo) {

        // If the current position is not a stone or it exceeds the last stone, return false
        if (!mp.getOrDefault(pos, false) || pos > stones.get(n - 1)) {
            return false;
        }

        // If the current position is the last stone, return true
        if (pos == stones.get(n - 1)) {
            return true;
        }

        // Create a unique key for memoization using the current position and previous step
        String key = pos + "," + prevStep;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean isPossible = false;

        // If we are at the starting stone (position 0), we can only jump 1 unit forward
        if (pos == 0) {
            isPossible = recursion(pos + 1, 1, stones, n, memo);
        } else {
            // Try to jump (prevStep-1), (prevStep), or (prevStep+1) units forward
            if (prevStep - 1 > 0) {
                isPossible = recursion(pos + (prevStep - 1), prevStep - 1, stones, n, memo);
            }
            if (isPossible) return true;

            isPossible = recursion(pos + prevStep, prevStep, stones, n, memo);
            if (isPossible) return true;

            isPossible = recursion(pos + (prevStep + 1), prevStep + 1, stones, n, memo);
            if (isPossible) return true;
        }

        // Store the result in the memoization map
        memo.put(key, isPossible);
        return isPossible;
    }

    // Method to check if the frog can cross the river
    public boolean canCross(int[] stones) {
        // Store all stone positions in the map
        for (int stone : stones) {
            mp.put(stone, true);
        }

        Map<String, Boolean> memo = new HashMap<>();
        int n = stones.length;

        // Start the recursion from position 0 with a step of 1
        return recursion(0, 1, toList(stones), n, memo);
    }

    // Helper method to convert an array to a list
    private List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }
}
