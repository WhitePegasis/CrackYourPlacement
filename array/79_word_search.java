//https://leetcode.com/problems/word-search/description/
package array;

class Solution {
    int[] dx={0,1,-1,0};
    int[] dy={1,0,0,-1};

    public boolean helper(char[][] board, int row, int col, String word, int currWordIdx){
        if(currWordIdx == word.length()){
            return true;
        }

        if (row >= board.length || row < 0 || col >= board[row].length || col < 0 || board[row][col] != word.charAt(currWordIdx) ) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        for(int i=0; i<4 ;i++){
            int nextRow=row+dx[i];
            int nextCol=col+dy[i];

            if(helper(board,nextRow ,nextCol , word , currWordIdx+1))
                return true;
        }

        board[row][col] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board, i, j, word, 0))
                        return true;
                }
            }
        }
        return false;
    }
}
