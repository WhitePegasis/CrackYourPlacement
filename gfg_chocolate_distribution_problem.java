// https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

import java.util.*;
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        long ans = Long.MAX_VALUE;
        
        Collections.sort(a);
        
        for(int i=0; i<n-m+1; i++){
            int temp = a.get(i+m-1) - a.get(i);
            ans = Math.min(temp, ans);
        }
        
        return ans;
    }
}