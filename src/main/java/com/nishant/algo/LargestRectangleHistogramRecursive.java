package com.nishant.algo;

public class LargestRectangleHistogramRecursive {

    private static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        //utility function to divide and conquer
        return maxRectangle(heights, 0, heights.length - 1);
    }

    private static int maxRectangle(int[] arr, int l, int r) {

        //check if current array is out of bounds
        if (l > r)
            return 0;

        //check if it has only one element then that bar is the max area
        if (l == r)
            return arr[l];

        //find the minimum index in the current range
        int minIndex = findMinIndex(arr, l, r);

        //recursively find max area in the left sub-array
        int left = maxRectangle(arr, l, minIndex - 1);

        //recursively find max area in the right sub-array
        int right = maxRectangle(arr, minIndex + 1, r);

        //find max area among left and right sub-arrays
        int max = Math.max(left, right);

        //compare max with min_bar * curr_range
        return Math.max(max, arr[minIndex] * (r - l + 1));
    }

    private static int findMinIndex(int[] arr, int l, int r) {
        int min = Integer.MAX_VALUE;
        int minIndex = l;
        for (int i = l; i <= r; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    public static void main(String[] args) {

        System.out.println(largestRectangleArea(new int[]{6, 1, 5, 4, 5, 2, 6}));
    }

}
