package com.nishant.algo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DistinctPermutation {
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return Collections.emptyList();

        List<List<Integer>> output = new ArrayList<>();

        permute(nums, 0, output);
        return output;
    }

    private static void permute(int[] nums, int currIndex, List<List<Integer>> output) {
        if (currIndex == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            output.add(temp);
        } else {
            for (int i = currIndex; i < nums.length; i++) {
                swap(nums, i, currIndex);// swap the elements to create permutation
                permute(nums, currIndex + 1, output); //create permutation on remaining elements
                swap(nums, i, currIndex); //revert the elements swapped
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(permute(new int[]{0, 1, 2}));
    }
}