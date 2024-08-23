//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
package stack_and_queues;

import java.util.ArrayDeque;

class Solution {
    public String removeDuplicates(String s, int k) {
        // ArrayDeque has better performance than Stack and LinkedList
        ArrayDeque<int[]> st = new ArrayDeque<>(s.length());

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peekLast()[0] == c) {
                st.peekLast()[1]++; // Increase the frequency
            } else {
                st.addLast(new int[]{c, 1});
            }
            if (st.peekLast()[1] == k) // If reach enough k duplicate letters -> then remove
                st.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        for (int[] a : st) {
            sb.append(String.valueOf((char) a[0]).repeat(a[1]));
        }
        return sb.toString();
    }
}
