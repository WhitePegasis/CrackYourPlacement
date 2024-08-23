//https://leetcode.com/problems/sum-of-subarray-minimums/
package stack_and_queues;

import java.util.*;

class Solution {
    // Function to calculate the sum of minimums of all subarrays
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        
        // Calculate the distances to the Next Smaller to the Left (NSL)
        int ans1[] = nsl(arr);
        
        // Calculate the distances to the Next Smaller to the Right (NSR)
        int ans2[] = nsr(arr);
        
        long sum = 0;
        
        // Modulus value as per the problem constraints
        int mod = 1000000007;
        
        // Calculate the sum of all subarray minimums
        for(int i = 0; i < n; i++) {
            // Compute the contribution of arr[i] as the minimum in subarrays
            // Contribution = arr[i] * Number of subarrays where arr[i] is the minimum
            sum = (sum + (long)(arr[i] * (long)(ans1[i] * ans2[i]) % mod) % mod) % mod;
        }
        
        // Return the sum as an integer
        return (int) sum;
    }

    // Function to find the Next Smaller to the Left (NSL) distances
    public static int[] nsl(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            // Pop elements from stack until the current element is greater than stack top
            while(!s.isEmpty() && arr[i] < arr[s.peek()]) {
                s.pop();
            }
            
            // If stack is empty, no smaller element to the left
            if(s.isEmpty()) {
                ans[i] = i - (-1); // Distance from start of array
            } else {
                // Distance from the previous smaller element
                ans[i] = i - s.peek();
            }
            
            // Push the current index onto the stack
            s.push(i);
        }
        
        return ans;
    }

    // Function to find the Next Smaller to the Right (NSR) distances
    public static int[] nsr(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[arr.length];
        
        for(int i = arr.length - 1; i >= 0; i--) {
            // Pop elements from stack until the stack top is greater or equal to the current element
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            
            // If stack is empty, no smaller element to the right
            if(s.isEmpty()) {
                ans[i] = arr.length - i; // Distance to end of array
            } else {
                // Distance to the next smaller element on the right
                ans[i] = s.peek() - i;
            }
            
            // Push the current index onto the stack
            s.push(i);
        }
        
        return ans;
    }
}

