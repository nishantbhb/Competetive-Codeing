package com.nishant.algo;

public class Pivot {
    private static int pivotIndex(int[] nums) {

        if (nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;
        int pivot = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                pivot = mid + 1;
            }
            if (nums[mid] > nums[start] && nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }

        return pivot;
    }


    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};

        int pivot = pivotIndex(nums);
        System.out.println(pivot);
    }
}
