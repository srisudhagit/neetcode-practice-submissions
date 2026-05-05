class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sumDp = new int[m][n];

        sumDp[m-1][n-1] = grid[m-1][n-1];
        
        for(int j = n-2;j >= 0; j--){
            sumDp[m-1][j] = grid[m-1][j] + sumDp[m-1][j+1];
        }

        for(int i = m-2;i >= 0; i--){
            sumDp[i][n-1] = grid[i][n-1] + sumDp[i+1][n-1];
        }

        for(int i = m-2;i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                sumDp[i][j] = grid[i][j] + Math.min(sumDp[i][j+1], sumDp[i+1][j]);
            }
        }

        for(int i =0 ; i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(sumDp[i][j] +" ");
            }
            System.out.println();
        }
        return sumDp[0][0];
    }
}