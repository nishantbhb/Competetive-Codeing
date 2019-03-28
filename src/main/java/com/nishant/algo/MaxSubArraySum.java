package com.nishant.algo;


class MaxSubArraySum {


    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            maxSum = (num > maxSum) ? num : maxSum;
        }

        if (maxSum <= 0) {//check for all negative numbers, then return max of negative integer
            return maxSum;
        }

        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            if (currSum <= 0) {
                currSum = 0;
                continue;
            }
            maxSum = (currSum > maxSum) ? currSum : maxSum;
        }
        return maxSum;

    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}