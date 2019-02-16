package com.nishant.algo;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray {
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0)
            return list;
        //start indexes
        int r = 0;
        int c = 0;
        //end indexes
        int m = matrix.length;
        int n = matrix[0].length;
        //visiting pointers
        int i = 0;
        int j = 0;
        int totalIndex = m * n;
        int cnt = 0;
        while (cnt < totalIndex) {

            while (j < n && cnt < totalIndex) {//visit top left to right
                list.add(matrix[i][j]);
                j++;
                cnt++;
            }
            r++; //remove topmost row
            j--; //bring column back to valid index
            i++; //set row index to one more than already visited row

            while (i < m && cnt < totalIndex) {//visit right top to bottom
                list.add(matrix[i][j]);
                i++;
                cnt++;
            }
            n--; //remove rightmost column
            i--; //bring row back to valid index
            j--; //set column index to one less than already visited column

            while (j >= c && cnt < totalIndex) {//visit bottom row
                list.add(matrix[i][j]);
                j--;
                cnt++;
            }
            m--; //remove bottom row
            j++; //bring column back to valid index
            i--; //set row index to one less than already visited row

            while (i >= r && cnt < totalIndex) {//visit left bottom to top
                list.add(matrix[i][j]);
                i--;
                cnt++;
            }
            c++; //remove rightmost column
            i++; //bring row back to valid index
            j++; //set column index to one more than already visited column
        }
        return list;

    }


    public static void main(String[] args) {

        int[][] nums = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> list = spiralOrder(nums);
        System.out.println(list);
    }
}