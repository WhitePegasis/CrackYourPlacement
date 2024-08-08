//https://leetcode.com/problems/decode-string/
package graph;

import java.util.*;

class Solution {
    public String decodeString(String s) {
        // Stack to store pairs of previous string and number of repetitions
        Stack<Pair<String, Integer>> st = new Stack<>();
        
        // Current string being processed
        String currStr = "";
        // Current number being processed
        int currNum = 0;
        
        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // If the character is a digit, update the current number
                currNum = currNum * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current string and number to the stack
                st.push(new Pair<>(currStr, currNum));
                // Reset current string and number
                currStr = "";
                currNum = 0;
            } else if (ch == ']') {
                // Pop the previous string and number from the stack
                Pair<String, Integer> p = st.pop();
                String prevStr = p.getKey();
                int count = p.getValue();
                
                // Repeat the current string 'count' times
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    temp.append(currStr);
                }
                
                // Concatenate the repeated string with the previous string
                currStr = prevStr + temp.toString();
            } else {
                // If the character is a letter, add it to the current string
                currStr += ch;
            }
        }
        
        // Return the fully decoded string
        return currStr;
    }
}
