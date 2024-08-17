//https://leetcode.com/problems/subsets/
package backtracking;

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> ans=new ArrayList<Integer>();

        helper(nums, 0, ans, res);
        return res;
    }
    private void helper(int[] nums, int index, List<Integer> ans, List<List<Integer>> res)  {
        if(index==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[index]);
        helper(nums, index+1, ans, res);
        ans.remove(ans.size()-1);

        helper(nums, index+1, ans, res);
    }
}