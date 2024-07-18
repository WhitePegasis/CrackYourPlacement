// https://leetcode.com/problems/4sum/

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            for(int j=i+1; j<n-2; j++){

                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int low=j+1;
                int high=n-1;
                long curr_target = (long)target - (long)nums[i] - nums[j];

                while(low<high){

                    if(nums[low]+nums[high] < curr_target){
                        low++;
                    }
                    else if(nums[low]+nums[high] > curr_target){
                        high--;
                    }
                    else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));

                        while(low<high && nums[low]==nums[low+1]){
                            low++;
                        }

                        while(low<high && nums[high]==nums[high-1]){
                            high--;
                        }

                        low++;
                        high--;
                    }

                }
            }
        }

        return res;
    }
}