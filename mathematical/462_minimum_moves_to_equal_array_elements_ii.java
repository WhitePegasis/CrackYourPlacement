// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

package mathematical;

import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        int middleElement=nums[n/2];

        int moves=0;
        
        for(int ele:nums){
            moves+=Math.abs(ele-middleElement);
        }
        
        return moves;
    }
}