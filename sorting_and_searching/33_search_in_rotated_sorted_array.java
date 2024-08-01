//https://leetcode.com/problems/search-in-rotated-sorted-array/
package sorting_and_searching;

class Solution {
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                return mid;
            }

            //check if left half is sorted
            if(nums[low] <= nums[mid]){
                if(target>=nums[low] && target<=nums[mid]) high = mid-1;
                else low = mid+1;
            }
            //if right half is sorted
            else{
                if(target>=nums[mid] && target<=nums[high]) low = mid+1;
                else high = mid-1;
            }
        }

        return -1;
    }
}