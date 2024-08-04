//https://leetcode.com/problems/backspace-string-compare/
package stack_and_queues;

class Solution {
    private String getString(String str) {
        int n=str.length(), count=0;
        StringBuilder result = new StringBuilder();
        for(int i=n-1; i>=0; i--) {
            char ch=str.charAt(i);
            if(ch=='#') 
                count++;
            else {
                if(count>0)
                    count--;
                else {
                    result.append(ch);
                }                     
            }
        }
        return result.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }
}