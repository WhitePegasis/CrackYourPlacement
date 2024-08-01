// https://leetcode.com/problems/maximal-rectangle/description/
package matrix;

import java.util.*;
class Solution {
    private int largestRectangleArea(int[] heights){
        int ans = 0;
        int i = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        while(i<=n){
            if(!st.isEmpty() && ( i==n || heights[i]<=heights[st.peek()] )){
                int height = heights[st.pop()];

                int width = 0;

                if(st.isEmpty()) width = i;
                else width = i - st.peek() - 1;

                ans = Math.max(ans, height*width);
            }
            else{
                st.push(i);
                i++;
            }
        }

        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];

        int ans = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='0'){
                    heights[j] = 0;
                }
                else{
                    heights[j]++;
                }
            }

            ans = Math.max(ans, largestRectangleArea(heights));
        }

        return ans;
    }
}