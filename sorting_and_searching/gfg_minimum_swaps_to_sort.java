//https://www.geeksforgeeks.org/problems/minimum-swaps/1

package sorting_and_searching;

import java.util.*;

class Solution
{
    private void swap(int[] arr, int x, int y)
    {
        int t= arr[x];
        arr[x]=arr[y];
        arr[y]=t;
    }
    
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int count=0;
        int n=nums.length;
        
        Map<Integer, Integer> map= new HashMap<>();
        
        for(int i=0; i<n; i++)
            map.put(nums[i],i);
            
        Arrays.sort(nums);
        
        int i=0;
        
        while(i<n)
        {
            if(i == map.get(nums[i])){
                i++;
                continue;
            }
            else
            {
                count++;
                swap(nums, i, map.get(nums[i]));
            }
        }
        
        return count;
    }
}