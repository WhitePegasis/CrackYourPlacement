// https://leetcode.com/problems/surrounded-regions/
package matrix;

class Solution {
    void dfs(int row, int col,int vis[][], char mat[][], int dx[], int dy[]) {
        vis[row][col] = 1; 
        int n = mat.length;
        int m = mat[0].length;
        
        // check for top, right, bottom, left 
        for(int i = 0;i<4;i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i]; 
            // check for valid coordinates and unvisited Os
            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
            && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, mat, dx, dy); 
            }
        }
    }
    void fill(int n, int m, char mat[][])
    {
        int dx[] = {-1, 0, +1, 0};
        int dy[] = {0, 1, 0, -1}; 
        int vis[][] = new int[n][m]; 
        // traverse first row and last row 
        for(int j = 0 ; j<m;j++) {
            // check for unvisited Os in the boundary rws
            // first row 
            if(vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, dx, dy); 
            }
            
            // last row 
            if(vis[n-1][j] == 0 && mat[n-1][j] == 'O') {
                dfs(n-1,j,vis,mat, dx, dy); 
            }
        }
        
        for(int i = 0;i<n;i++) {
            // check for unvisited Os in the boundary columns
            // first column 
            if(vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, dx, dy); 
            }
            
            // last column
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, dx, dy); 
            }
        }
        
        // if unvisited O then convert to X
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(vis[i][j] == 0 && mat[i][j] == 'O') 
                    mat[i][j] = 'X'; 
            }
        }
    }
    public void solve(char[][] board) {
        fill(board.length, board[0].length, board);
    }
}