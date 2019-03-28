package com.nishant.dp;


class UniquePathsWithObstaclesDP {


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null)
            return 0;
        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m][n] == 1)
            return 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                obstacleGrid[i][j] *= -1;//to make sure it is distinct from array values later
            }
        }
        return uniquePathsUtil(m, n, obstacleGrid);

    }


    private static int uniquePathsUtil(int r, int c, int[][] dp) {

        if (r == 0 && c == 0)
            return 1;
        if (r < 0 || c < 0 || dp[r][c] == -1) {
            return 0;
        }
        if (dp[r][c] > 0)
            return dp[r][c];
        dp[r][c] = uniquePathsUtil(r - 1, c, dp) + uniquePathsUtil(r, c - 1, dp);
        return dp[r][c];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}}));
    }

}