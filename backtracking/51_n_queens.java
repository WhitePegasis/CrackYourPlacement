//https://leetcode.com/problems/n-queens/
package backtracking;

import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with '.' indicating empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Start the backtracking process
        solveNQueensUtil(board, 0, results);
        return results;
    }

    private void solveNQueensUtil(char[][] board, int row, List<List<String>> results) {
        int n = board.length;
        if (row == n) {
            // All queens are placed successfully
            results.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen
                solveNQueensUtil(board, row + 1, results); // Recur to place the next queen
                board[row][col] = '.'; // Remove the queen (backtrack)
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    
}