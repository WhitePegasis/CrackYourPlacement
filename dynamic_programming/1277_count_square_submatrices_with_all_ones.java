//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
package dynamic_programming;

import java.util.Arrays;
import java.util.List;

// O(m * n)
class Solution {
    private final List<Integer[]> directions = List.of(
            new Integer[]{1, 0}, new Integer[]{0, 1}, new Integer[]{1, 1}
    );

    public int countSquares(int[][] matrix) {
        int count = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int[] row: memo) Arrays.fill(row, -1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count += expand(i, j, matrix, memo);
            }
        }
        return count;
    }

    private int expand(int i, int j, int[][] matrix, int[][] memo) {
        if(notValid(i, j, matrix)) return 0;
        if(matrix[i][j] == 0) {
            memo[i][j] = 0;
            return memo[i][j];
        }
        if(memo[i][j] != -1) return memo[i][j];
        int min = Integer.MAX_VALUE;
        for (Integer[] direction: directions) {
            int x = i + direction[0], y = j + direction[1];
            min = Math.min(min, expand(x, y, matrix, memo));
        }
        memo[i][j] = 1 + min;
        return memo[i][j];
    }

    private boolean notValid(int i, int j, int[][] matrix) {
        return i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length;
    }
}