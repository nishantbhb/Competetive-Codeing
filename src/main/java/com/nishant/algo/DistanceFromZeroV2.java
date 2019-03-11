package com.nishant.algo;

class DistanceFromZeroV2 {
    public int[][] updateMatrix(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        //traverse top left to bottom right
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] != 0) {
                    int min = 100000;
                    if (i > 0) {
                        min = Math.min(min, matrix[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        min = Math.min(min, matrix[i][j - 1] + 1);
                    }
                    matrix[i][j] = min;
                }
            }
        }
        //traverse bottom right to top left
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    if (i < r - 1) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                    }
                    if (j < c - 1) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
                    }
                }
            }
        }
        return matrix;
    }

}
