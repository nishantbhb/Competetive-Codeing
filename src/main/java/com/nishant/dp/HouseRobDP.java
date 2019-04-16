package com.nishant.dp;


class HouseRobDP {


    //cannot rob two adjacent houses

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] fibo = new int[nums.length];
        fibo[0] = nums[0];
        if (nums.length >= 2)
            fibo[1] = Math.max(nums[0], nums[1]); //for case [2,1,1,2]


        for (int i = 2; i < nums.length; i++) {
            fibo[i] = Math.max(fibo[i - 2] + nums[i], fibo[i - 1]);
        }

        return fibo[nums.length - 1];

    }

}