package com.nishant.dp;


class MinPathSumDP {


    public static int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                int m = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
                int n = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;

                grid[i][j] += Math.min(m, n);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];

    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}}));
    }

}