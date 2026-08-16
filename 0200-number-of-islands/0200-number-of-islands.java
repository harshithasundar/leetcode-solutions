class Solution {
    public int numIslands(char[][] grid) {
        //edge case: empty grid
        if( grid==null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount =0;
        
        //traverse each cell
        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                //found an unvisited land cell
                if(grid[i][j] == '1'){
                    islandCount++;
                    //call dfs to mark all connected lands
                    dfs(grid,i,j);
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int row, int col){
        //boundary and water checks
        if(row<0 || row >= grid.length || col < 0 || col>=grid[0].length || grid[row][col]=='0'){
            return;
        }
        //mark as visited
        grid[row][col] = '0';

        //exploring all 4 directions
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid,row,col-1);
        dfs(grid, row, col+1);
    } 
}