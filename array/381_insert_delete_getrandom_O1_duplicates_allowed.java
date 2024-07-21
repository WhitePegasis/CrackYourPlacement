//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
package array;

import java.util.*;

class RandomizedCollection {
    ArrayList<Integer> nums;
    Map<Integer, Set<Integer>> location;
    Random random;

    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        location = new HashMap<Integer, Set<Integer>>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        boolean present = location.containsKey(val);
        if(!present){
            location.put(val, new LinkedHashSet<Integer>());
        }

        location.get(val).add(nums.size());
        nums.add(val);

        return !present;
        
    }
    
    public boolean remove(int val) {

        boolean present = location.containsKey(val);
	    if ( ! present ) return false;

	    int loc = location.get(val).iterator().next();
	    location.get(val).remove(loc);
	    if (loc < nums.size() - 1 ) {
	       int lastone = nums.get( nums.size()-1 );
	       nums.set( loc , lastone );
	       location.get(lastone).remove( nums.size()-1);
	       location.get(lastone).add(loc);
	    }
	    nums.remove(nums.size() - 1);
	   
	    if (location.get(val).isEmpty()) location.remove(val);
	    return true;
        
    }
    
    public int getRandom() {
        return nums.get( random.nextInt(nums.size()) );
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */