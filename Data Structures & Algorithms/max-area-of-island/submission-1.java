class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, area = 0;
        
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    area = bfs(i, j, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int bfs(int i, int j, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length;
        queue.offer(new int[]{i,j});
        grid[i][j] = 2;
        int[][] direc = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int area = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int[] dir : direc){
                int tempx = temp[0] + dir[0];
                int tempy = temp[1] + dir[1];
                if(tempx >=0 && tempx < rows && tempy >= 0 && tempy < cols && grid[tempx][tempy] == 1){
                    queue.offer(new int[]{tempx, tempy});
                    grid[tempx][tempy] = 2;
                    area++;
                }
            }
        }
        return area;
    }
}
