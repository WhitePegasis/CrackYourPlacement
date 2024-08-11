//https://leetcode.com/problems/longest-repeating-character-replacement/
package two_pointers_and_sliding_window;

import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();

        HashMap<Character, Integer> count = new HashMap<>();

        int start = 0, maxCount = 0, maxLength = 0;

        for (int end = 0; end < len; end++) {
            char currentChar = s.charAt(end);
            count.put(currentChar, count.getOrDefault(currentChar, 0) + 1);

            maxCount = Math.max(maxCount, count.get(currentChar));

            while ((end - start + 1) - maxCount > k) {
                char startChar = s.charAt(start);
                count.put(startChar, count.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
