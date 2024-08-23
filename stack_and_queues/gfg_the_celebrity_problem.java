//https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
package stack_and_queues;

// T.C = O(2N) , S.C= O(1)
class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        
        int top = 0;
        int down = mat.length-1;
        
        while(top < down){
            if(mat[top][down] == 1){
                top++;
            }
            else if(mat[down][top] == 1){
                down--;
            }
            else{
                top++;
                down--;
            }
        }
        
        if(top > down) return -1;
        
        for(int i=0; i<mat.length; i++){
            if(i==top) continue;
            
            if(mat[top][i] != 0 || mat[i][top] != 1) return -1; 
        }
        
        return top;
    }
}
