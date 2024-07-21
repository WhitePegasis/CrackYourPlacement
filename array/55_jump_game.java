//https://leetcode.com/problems/jump-game/description/
package array;

class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;

        if(n==1){
            return true;
        }

        int currJump = nums[0];

        int i=1;
        while(i<n && currJump > 0){
            currJump--;

            currJump = Math.max(currJump, nums[i]);

            i++;
        }

        return i==n;
    }
}