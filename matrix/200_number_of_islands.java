// https://leetcode.com/problems/number-of-islands/
package matrix;

class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int N=grid.length;
        int M=grid[0].length;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j,N,M);
                }
            }
        }
        
        return count;
    }
    void dfs(char[][] grid, int i,int j, int N, int M){
        grid[i][j]='2'; //marking as visited
        
        if(i-1>=0 && grid[i-1][j]=='1'){
            dfs(grid,i-1,j,N,M);
        }
        if(i+1<N && grid[i+1][j]=='1'){
            dfs(grid,i+1,j,N,M);
        }
        if(j-1>=0 && grid[i][j-1]=='1'){
            dfs(grid,i,j-1,N,M);
        }
        if(j+1<M && grid[i][j+1]=='1'){
            dfs(grid,i,j+1,N,M);
        }
    }

}
