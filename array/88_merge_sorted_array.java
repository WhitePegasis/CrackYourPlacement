//https://leetcode.com/problems/merge-sorted-array/description/
package array;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int curr_idx = m+n-1;

        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]) nums1[curr_idx--] = nums1[i--];
            else nums1[curr_idx--] = nums2[j--];
        }
    }
}