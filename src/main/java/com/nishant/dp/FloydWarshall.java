package com.nishant.dp;

public class FloydWarshall {
    //updating the same matrix :P
    public static void findMinDist(int[][] grid) {
        for (int k = 0; k < grid[0].length; k++) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }

    }
}
