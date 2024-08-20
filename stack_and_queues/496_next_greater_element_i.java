package stack_and_queues;

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        // Create a map to store the next greater element for each number in nums
        Map<Integer, Integer> map = new HashMap<>();
        // Stack to help in finding the next greater element
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through each number in nums array
        for (int num : nums) {
            // If the stack is not empty and the current number is greater than the stack's top element,
            // pop elements from the stack and map them to the current number as the next greater element
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            // Push the current number to the stack to potentially find its next greater element later
            stack.push(num);
        }
        
        // For each number in findNums, replace it with its next greater element from the map,
        // or -1 if no greater element exists
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        
        // Return the updated findNums array with the next greater elements
        return findNums;
    }
}
