class Solution {
    public int numIslands(char[][] grid) {
        int islandCnt = 0;
        int rows = grid.length, cols = grid[0].length;

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '2';
                    dfs(i, j, grid);
                    islandCnt++;
                }
            }
        }
        return islandCnt;
    }

    public void dfs(int row, int col, char[][] grid){
        int[][] direc = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        int rows = grid.length, cols = grid[0].length;

        for(int[] dir : direc){
            int nr = dir[0]+row;
            int nc = dir[1]+col;

            if(0 <= nr && nr < rows && 0 <= nc && nc < cols && grid[nr][nc] == '1'){
                grid[nr][nc] = '2';
                dfs(nr, nc, grid);
            }
        }
    }
}
