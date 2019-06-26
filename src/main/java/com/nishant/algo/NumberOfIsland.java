package com.nishant.algo;


public class NumberOfIsland {
    static int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        int ctr = 0;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    markVisited(grid, i, j);
                    ctr++;

                }
            }
        }
        return ctr;
    }

    static void markVisited(char[][] grid, int m, int n) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == '0')
            return;

        grid[m][n] = '0';
        markVisited(grid, m, n - 1);
        markVisited(grid, m, n + 1);
        markVisited(grid, m - 1, n);
        markVisited(grid, m + 1, n);
    }

    public static void main(String[] args) {
        System.out.println(numIslands(
                new char[][]{{'1', '1', '1'},
                        {'0', '1', '0'},
                        {'1', '1', '1'}}));
    }

}