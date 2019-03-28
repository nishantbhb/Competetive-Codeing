package com.nishant.dp;


class UniquePathsDP {


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePathsUtil(m - 1, n - 1, dp);

    }

    private int uniquePathsUtil(int r, int c, int[][] dp) {

        if (r == 0 && c == 0)
            return 1;
        if (r < 0 || c < 0)
            return 0;
        if (dp[r][c] > 0)
            return dp[r][c];
        dp[r][c] = uniquePathsUtil(r - 1, c, dp) + uniquePathsUtil(r, c - 1, dp);
        return dp[r][c];
    }

}