//https://www.geeksforgeeks.org/problems/permutations-in-array1747/1

package sorting_and_searching;

import java.util.*;

class Solution {
    public boolean isPossible(long a[], long b[], int n, long k) {
        // Sort arrays a[] and b[]
        Arrays.sort(a);
        Arrays.sort(b);
        
        // Check if there exists a permutation where a[i] + b[i] >= k for all i
        for(int i = 0; i < n; i++) {
            if(a[i] + b[n - 1-i] < k) {
                return false; // Not possible
            }
        }
        
        return true; // Possible
    }
}