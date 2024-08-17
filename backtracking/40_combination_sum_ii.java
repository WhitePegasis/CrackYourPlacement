//https://leetcode.com/problems/combination-sum-ii/
package backtracking;

import java.util.*;

class Solution {
    // Main function to find all unique combinations that sum to the target
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // This will store all the valid combinations
        List<List<Integer>> ans = new ArrayList<>();
        
        // Sort the array to handle duplicates easily and to optimize the process
        Arrays.sort(candidates);
        
        // Call the recursive helper function to find combinations
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        
        // Return the list of all unique combinations
        return ans;
    }

    // Recursive function to find combinations
    static void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> combination) {
        // Base case: if the target is 0, add the current combination to the result list
        if (target == 0) {
            ans.add(new ArrayList<>(combination)); // Make a copy of the current combination
            return;
        }

        // Iterate through the array to find valid combinations
        for (int i = index; i < arr.length; i++) {
            // Skip duplicate elements to avoid repeating the same combination
            if (i > index && arr[i] == arr[i - 1]) continue;
            
            // If the current element is greater than the target, no need to continue (array is sorted)
            if (arr[i] > target) break;

            // Include the current element in the combination
            combination.add(arr[i]);
            
            // Recur to find the rest of the combination, moving to the next element
            findCombinations(i + 1, arr, target - arr[i], ans, combination);
            
            // Backtrack: remove the last element to try the next combination
            combination.remove(combination.size() - 1);
        }
    }
}
