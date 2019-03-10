package com.nishant.algo;

import java.util.Arrays;

public class FillColor {


    static void changeColor(int[][] image, int m, int n, int matchColor, int newColor) {
        if (m < 0 || n < 0 || m >= image.length || n >= image[0].length || image[m][n] != matchColor)
            return;

        image[m][n] = newColor;
        changeColor(image, m, n - 1, matchColor, newColor);
        changeColor(image, m, n + 1, matchColor, newColor);
        changeColor(image, m + 1, n, matchColor, newColor);
        changeColor(image, m - 1, n, matchColor, newColor);

    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        int matchColor = image[sr][sc];
        changeColor(image, sr, sc, matchColor, newColor);
        return image;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1)));
    }

}