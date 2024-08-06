//https://www.geeksforgeeks.org/problems/steps-by-knight5927/1
package graph;

import java.util.*;

class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int pos[], int to[], int N)
    {
        int[][] moves = { {-1, -2}, {1, -2}, {2, -1},  {2, 1}, {-1, 2},  {1, 2}, {-2, -1}, {-2, 1}};
        int[][] board = new int[N+1][N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        board[pos[0]][pos[1]] = 1;
        queue.add(pos[0]<<16 | pos[1]);
        while(!queue.isEmpty()) {
            int i0 = queue.peek() >> 16;
            int j0 = queue.poll() & 0xFFFF;
            if (i0==to[0] && j0==to[1])
                return board[i0][j0]-1;
            for(int[] move: moves) {
                int i = i0 + move[0];
                int j = j0 + move[1];
                if(i>=1 && i<=N && j>=1 && j<=N && board[i][j] == 0) {
                    board[i][j] = board[i0][j0] + 1;
                    queue.add(i<<16 | j);
                }
            }
        } 
        return -1;    
    }
}