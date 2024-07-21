//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
package array;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1, n=nums.length;

        int count=1;

        while(i<n){
            while(i<n && nums[i] == nums[i-1]) i++;

            if(i<n){
                nums[count] = nums[i];
                count++;
            }
            
            i++;
        }

        return count;
    }
}