// https://leetcode.com/problems/subarray-sums-divisible-by-k/

import java.util.*;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int preSum=0;

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);

        int ans=0;

        for(int i=0; i<nums.length; i++){
            preSum += nums[i];
            int rem = preSum%k;

            if(rem < 0){
                rem = rem + k;
            }

            if(mp.containsKey(rem)){
                ans += mp.get(rem);
            }
            
            mp.put(rem, mp.getOrDefault(rem,0) + 1);
        }

        return ans;

    }
}