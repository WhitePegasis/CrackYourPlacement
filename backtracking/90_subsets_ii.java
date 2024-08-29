//https://leetcode.com/problems/subsets-ii/
package backtracking;

import java.util.*;

class Solution {

    // Helper function to find subsets
    private void findSubsets(List<Integer> nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the list of results
        result.add(new ArrayList<>(current));

        // Iterate over the remaining elements to construct subsets
        for (int i = index; i < nums.size(); i++) {
            // Skip duplicate elements to avoid duplicate subsets
            if (i != index && nums.get(i).equals(nums.get(i - 1))) continue;

            // Include the current element in the subset
            current.add(nums.get(i));

            // Recursively find subsets with the current element included
            findSubsets(nums, i + 1, current, result);

            // Backtrack by removing the last added element
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Result list to store all unique subsets
        List<List<Integer>> result = new ArrayList<>();

        // Current list to keep track of the current subset
        List<Integer> current = new ArrayList<>();

        // Convert the input array to a list for easier manipulation
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        // Sort the list to handle duplicates
        numsList.sort(null);

        // Start the recursion to find subsets
        findSubsets(numsList, 0, current, result);

        return result;
    }
}
