package com.nishant.algo;

class DistanceFromZero {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return new int[][]{};
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0 && !zeroNeighbour(matrix, i, j)) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    updateDistance(matrix, i, j, 0);
            }
        }


        return matrix;
    }

    boolean zeroNeighbour(int[][] matrix, int i, int j) {
        if (i > 0 && matrix[i - 1][j] == 0)
            return true;
        if (j > 0 && matrix[i][j - 1] == 0)
            return true;
        if (i < matrix.length - 1 && matrix[i + 1][j] == 0)
            return true;
        if (j < matrix[0].length - 1 && matrix[i][j + 1] == 0)
            return true;

        return false;
    }

    void updateDistance(int[][] matrix, int m, int n, int currDist) {
        if (m < 0 || n < 0 || m >= matrix.length || n >= matrix[0].length || matrix[m][n] <= currDist)
            return;


        if (currDist > 0)
            matrix[m][n] = currDist + 1;

        updateDistance(matrix, m, n - 1, matrix[m][n]);
        updateDistance(matrix, m, n + 1, matrix[m][n]);
        updateDistance(matrix, m + 1, n, matrix[m][n]);
        updateDistance(matrix, m - 1, n, matrix[m][n]);

    }
}}