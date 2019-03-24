package com.nishant.algo;


import java.util.HashMap;
import java.util.Map;

class CountSubarraysum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);// for element where nums[i] == k
        for (int num : nums) {
            sum += num;
            count += preSumFreq.getOrDefault(sum - k, 0);
            preSumFreq.put(sum, preSumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;


        /*
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
         */
    }


    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
    }
}