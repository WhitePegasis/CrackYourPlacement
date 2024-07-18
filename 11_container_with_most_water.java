// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int ans = 0;

        int i=0, j=height.length -1;

        while(i<j){
            int min_pole = Math.min(height[i], height[j]);
            int curr_dist = j-i;
            ans = Math.max( min_pole*curr_dist, ans);

            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        } 

        return ans;
    }
}