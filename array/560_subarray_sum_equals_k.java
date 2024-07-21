// https://leetcode.com/problems/subarray-sum-equals-k/
package array;

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        mp.put(0,1);

        int sum = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(mp.containsKey(sum - k)){
                ans += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum,0) + 1);
        }

        return ans;
    }
}