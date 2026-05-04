class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = (m > 1 && n > 1)? 1 : (obstacleGrid[m-1][n-1] == 1 ? 0 : 1);

        for(int i = m-2;i >=0; i--){
            dp[i][n-1] = ((obstacleGrid[i][n-1] == 1 || dp[i+1][n-1] == 0)  ? 0 : 1);
        }

        for(int j = n-2;j >=0; j--){
            dp[m-1][j] = ((obstacleGrid[m-1][j] == 1 || dp[m-1][j+1] == 0)? 0 : 1);
        }

        for(int i = m-2; i >= 0; i--){
            for(int j = n-2;j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (dp[i+1][j] == 0 ? 0 : dp[i+1][j]) +
                           (dp[i][j+1] == 0 ? 0 : dp[i][j+1]);
                }      
            }
        }

        for(int i = 0; i< m;i++){
            for(int j = 0;j < n;j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}