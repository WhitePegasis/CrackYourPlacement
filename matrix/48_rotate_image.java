// https://leetcode.com/problems/rotate-image/

package matrix;

class Solution {
    private static void reverse(int[] row) {

        int left = 0, right = row.length - 1;

        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[][] matrix) {
        int row = matrix.length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < row; i++) {
            reverse(matrix[i]);
        }
    }
}
