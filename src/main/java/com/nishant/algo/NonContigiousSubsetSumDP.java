package com.nishant.algo;


class NonContigiousSubsetSumDP {
    static int maxSubsetSum(int[] arr) {

        if (arr == null)
            return 0;
        if (arr.length == 1)
            return arr[0];
        if (arr.length == 2)
            return Math.max(arr[0], arr[1]);

        int[] maxSum = new int[arr.length];

        maxSum[0] = arr[0];
        maxSum[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            maxSum[i] = Math.max(arr[i], Math.max(maxSum[i - 2] + arr[i], maxSum[i - 1]));
        }
        return maxSum[arr.length - 1];


    }


    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int[]{1, 2, 3, 4, 5, 6, 2, 5}));
    }
}