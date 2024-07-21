//https://leetcode.com/problems/max-value-of-equation/description/
package array;

import java.util.*;

// Generic Pair class with two type parameters T1 and T2
class Pair<T1 extends Comparable<T1>, T2> implements Comparable<Pair<T1, T2>> {
    private T1 key;
    private T2 value;

    public Pair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair<T1, T2> other) {
        // Assuming we want a max heap based on the key
        // Cast key to Comparable to use compareTo method
        return ((Comparable<T1>) other.key).compareTo(this.key);
    }
}

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq= new PriorityQueue<>();

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<points.length; i++){
            while(!pq.isEmpty() && (points[i][0] - pq.peek().getValue()>k) ) pq.poll();

            if(!pq.isEmpty()){
                ans = Math.max(ans, points[i][0]+points[i][1] + pq.peek().getKey());
            }

            pq.offer(new Pair<>(points[i][1] - points[i][0], points[i][0]) );
        }

        return ans;
    }
}