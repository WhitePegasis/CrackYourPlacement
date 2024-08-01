//https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1
package sorting_and_searching;

import java.util.*;

class Solution {
    public int findPair(int n, int x, int[] arr) {
        Arrays.sort(arr);
        
        int i=0,j=1;
         
        while(i<n && j<n){
            
            if(i!=j && arr[j]-arr[i]==x) return 1;
            else if(arr[j]-arr[i]>x) i++;
            else j++;
        }
        return -1;
    }
}
