package com.nishant.algo;


import java.util.Arrays;

class ProductExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int prod = 1;
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prod *= nums[i - 1];
            output[i] = prod;
        }
        prod = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            output[i] *= prod;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 1})));
    }
}