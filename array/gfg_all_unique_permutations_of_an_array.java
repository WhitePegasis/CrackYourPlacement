//https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/0
package array;

import java.util.*;

class Solution {
    static class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

      @Override
      public int compare(List<T> o1, List<T> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
          int c = o1.get(i).compareTo(o2.get(i));
          if (c != 0) {
            return c;
          }
        }
        return Integer.compare(o1.size(), o2.size());
      }
    
    }
    
    static void helper(ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> ans, int currIdx, int n){
        if(currIdx==n){
            ans.add(new ArrayList<>(arr));
            return;
        }
        
        Set<Integer> set= new HashSet<>();
        
        for(int i=currIdx; i<n ; i++){
            if(set.contains(arr.get(i))) continue;
            set.add(arr.get(i));
            
            Collections.swap(arr, i, currIdx);
            
            helper(arr,ans, currIdx+1, n);
            
            Collections.swap(arr, i, currIdx);
        }
            
    }
    
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        helper(arr, ans, 0, n);
        
        Collections.sort(ans, new ListComparator<>());
        
        // Collections.sort(ans);
        
        return ans;
    }
};