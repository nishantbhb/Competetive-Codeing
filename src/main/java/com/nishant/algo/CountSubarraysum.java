package com.nishant.algo;


class CountSubarraysum {
    public static int subarraySum(int[] nums, int s) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] cumSum = new int[nums.length + 1];
        int ctr = 0;
        cumSum[0] = 0;
        for (int i = 1; i < cumSum.length; i++) {
            cumSum[i] = cumSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < cumSum.length - 1; i++) {
            for (int j = i + 1; j < cumSum.length; j++) {
                if (cumSum[j] - cumSum[i] == s)
                    ctr++;

            }
        }
        return ctr;
    }


    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
    }
}