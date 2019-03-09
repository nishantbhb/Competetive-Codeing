package com.nishant.algo;

public class NumberOfWaysToSum {

    static int findTargetSumWays(int[] nums, int S) {
        return countWays(nums, 0, S, 0);

    }

    static int countWays(int[] nums, int i, int S, int currSum) {
        int ctr = 0;
        if (i == nums.length - 1) {
            if (currSum + nums[i] == S)
                ctr++;
            if (currSum - nums[i] == S)
                ctr++;

            return ctr;
        }

        return countWays(nums, i + 1, S, currSum + nums[i])
                + countWays(nums, i + 1, S, currSum - nums[i]);


    }

    public static void main(String[] args) {

        System.out.println(findTargetSumWays(new int[]{1, 0}, 1));
    }

}