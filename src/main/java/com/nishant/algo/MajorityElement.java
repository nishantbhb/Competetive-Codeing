package com.nishant.algo;


class MajorityElement {
    public static int majorityElement(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maj = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maj) {
                times++;
            } else {
                if (times == 0) {
                    maj = nums[i];
                    times = 1;
                } else
                    times--;
            }
        }
        return maj;
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3, 4, 5, 3, 3}));
    }
}