//https://leetcode.com/problems/climbing-stairs/
package dynamic_programming;

class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        
        int[] arr = new int[n+1];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3;i<n+1;i++){
            arr[i] = arr[i-1] + arr[i-2]; 
        }
        
        return arr[n];
    }
}