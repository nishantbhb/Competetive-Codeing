package com.nishant.algo;

public class ProjectionArea3D {

    public int projectionArea(int[][] grid) {
        int n = grid[0].length;
        int xy = 0;
        int yz = 0;
        int[] xz = new int[n];

        for (int i = 0; i < grid.length; i++) {
            int max_yz = 0;
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];
                if (curr > 0)
                    xy++;
                max_yz = Math.max(max_yz, curr);
                xz[j] = Math.max(xz[j], curr);
            }
            yz += max_yz;
        }

        for (int j = 0; j < n; j++) {
            xy += xz[j];
        }
        return xy + yz;
    }

}
