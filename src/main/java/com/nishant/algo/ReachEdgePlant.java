package com.nishant.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReachEdgePlant {

    /* test case
    4 5
1 1 1 0 1
1 0 2 0 1
0 0 1 0 1
1 0 1 1 0
     */
    private static int min = Integer.MAX_VALUE;

    public static int solveIt(int n, int m, int[][] G) {
        int r = 0, c = 0;

        x:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (G[i][j] == 2) {
                    r = i;
                    c = j;
                    G[i][j] = 0;//reset for first condition
                    break x;
                }

            }
        }


        calcPathUtil(G, r, c, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static void calcPathUtil(int[][] grid, int i, int j, int ctr) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 0)
            return;

        if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 0) {
            min = Math.min(min, ctr);
            return;
        }

        grid[i][j] = 1; // mark visited
        calcPathUtil(grid, i, j + 1, ctr + 1);
        calcPathUtil(grid, i - 1, j, ctr + 1);
        calcPathUtil(grid, i, j - 1, ctr + 1);
        calcPathUtil(grid, i + 1, j, ctr + 1);
    }

    public static void main(String[] args) throws Exception {
        int[][] G;
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        G = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++)
                G[i][j] = Integer.parseInt(temp[j]);
        }
        out.println(solveIt(n, m, G));
        br.close();
        out.close();
    }
}


