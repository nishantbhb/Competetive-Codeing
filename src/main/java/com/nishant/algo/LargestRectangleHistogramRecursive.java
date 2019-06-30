package com.nishant.algo;

public class LargestRectangleHistogramRecursive {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        return maxRectangle(heights, 0, heights.length - 1);
    }

    private static int maxRectangle(int[] arr, int l, int r) {

        if (l > r)
            return 0;

        if (l == r)
            return arr[l];

        int minIndex = findMinIndex(arr, l, r);

        int left = maxRectangle(arr, l, minIndex - 1);
        int right = maxRectangle(arr, minIndex + 1, r);

        int max = Math.max(left, right);
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
        System.out.println(largestRectangleArea(new int[]{2, 1, 2}));
    }

}
