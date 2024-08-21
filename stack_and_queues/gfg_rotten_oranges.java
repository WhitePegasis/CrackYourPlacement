//https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
package stack_and_queues;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to find the minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        // Queue to store the coordinates of rotten oranges.
        Queue<int[]> q = new LinkedList<>();
        
        // Dimensions of the grid.
        int m = grid.length;
        int n = grid[0].length;
        
        // Traverse the grid to find all initially rotten oranges.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // Add the position of the rotten orange to the queue.
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // Variable to track the time required for all oranges to rot.
        int time = 0; 
        
        // Process the queue until all reachable fresh oranges have rotted.
        while (!q.isEmpty()) {
            int sz = q.size();
            int temp = 0; // Used to track if any orange rotted during this iteration.
            
            // Process all rotten oranges at the current level.
            for (int i = 0; i < sz; i++) {
                int[] curr = q.poll(); // Get the current rotten orange's coordinates.
                
                int x = curr[0];
                int y = curr[1];
                
                // Check all four directions (up, down, left, right) for fresh oranges.
                
                // Check the cell above.
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    temp = 1; // Indicates that an orange has rotted.
                    q.add(new int[]{x - 1, y}); // Add the newly rotten orange to the queue.
                    grid[x - 1][y] = 2; // Mark the orange as rotten in the grid.
                }
                
                // Check the cell to the left.
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    temp = 1;
                    q.add(new int[]{x, y - 1});
                    grid[x][y - 1] = 2;
                }
                
                // Check the cell to the right.
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    temp = 1;
                    q.add(new int[]{x, y + 1});
                    grid[x][y + 1] = 2;
                }
                
                // Check the cell below.
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    temp = 1;
                    q.add(new int[]{x + 1, y});
                    grid[x + 1][y] = 2;
                }
            }
            
            // If any orange rotted during this round, increment the time.
            time += temp;
        }
        
        // After processing all possible rottings, check if any fresh orange is left.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // If a fresh orange is found, it's impossible to rot all oranges.
                    return -1;
                }
            }
        }
        
        // Return the total time required to rot all oranges.
        return time;
    }
}
