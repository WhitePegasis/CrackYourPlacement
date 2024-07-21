// https://leetcode.com/problems/find-all-duplicates-in-an-array/
package array;

import java.util.*;

class Solution {

    public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();

            for(int i=0; i<nums.length; i++){
                int curr_idx = Math.abs(nums[i]) - 1;

                if(nums[curr_idx] < 0){
                    res.add(Math.abs(nums[i]));
                }

                nums[curr_idx] = -Math.abs(nums[curr_idx]);
            } 

            return res;
    }
}