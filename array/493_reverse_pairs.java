//https://leetcode.com/problems/reverse-pairs/description/
package array;

import java.util.*;

class Solution {

    int count = 0;

    private void countPairs(int[] a, int l, int mid, int r){

        //counting pairs
        int i=l;
        int j = mid+1;

        while(i<=mid && j<=r){
            if(a[i] > (long)2*a[j]){
                count += mid-i +1;
                j++;
            }
            else{
                i++;
            }
        }
    }

    private void merge(int[] a,int l, int mid, int r){
        countPairs(a, l, mid, r);

        //normal merge logic

        int i=l; 
        int j=mid+1;

        List<Integer> res = new ArrayList<>();

        while(i<=mid && j<=r){
            if(a[i] <= a[j]){
                res.add(a[i++]);
            }
            else{
                res.add(a[j++]);
            }
        }

        while(i <= mid){
            res.add(a[i++]);
        }

        while(j < r){
            res.add(a[j++]);
        }
        
        i=l;
        for(int num: res){
            a[i++]=num;
        }

    }

    private void mergeSort(int[] a, int l, int r){
        if(l>=r)
            return;

        int m= l+ (r-l)/2;

        mergeSort(a, l, m);
        mergeSort(a, m+1, r);

        merge(a, l, m, r);
    }

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return count;
    }
}