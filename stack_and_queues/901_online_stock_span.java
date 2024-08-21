//https://leetcode.com/problems/online-stock-span/
package stack_and_queues;

import java.util.Stack;

class StockSpanner {
    // Stack to store pairs of [price, span].
    Stack<int[]> stack;

    // Constructor to initialize the stack.
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    // Method to calculate the stock span for the given price.
    public int next(int price) {
        // Initialize the span as 1 (the current day itself).
        int res = 1;

        // Process the stack while it's not empty and the current price is greater
        // than or equal to the price at the top of the stack.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the span of the price at the top of the stack to the current span.
            res += stack.pop()[1];
        }
        
        // Push the current price and its calculated span onto the stack.
        stack.push(new int[]{price, res});
        
        // Return the calculated span for the current price.
        return res;
    }
}

