package com.nishant.algo;


class MaxNonContigiousSum {
    static int maxSubsetSum(int[] arr) {

        return subsetHelper(arr, 0, 0);


    }

    private static int subsetHelper(int[] arr, int i, int sum) {
        if (i >= arr.length)
            return sum;
        return Math.max(subsetHelper(arr, i + 2, sum + arr[i]), subsetHelper(arr, i + 1, sum));
    }


    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
    }
}