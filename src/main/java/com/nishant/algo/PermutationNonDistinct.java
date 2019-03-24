package com.nishant.algo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PermutationNonDistinct {
    public static void main(String[] args) {
        //System.out.println(permuteUnique(new int[]{0, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        permute(ans, nums, 0);
        return ans;
    }

    private void permute(List<List<Integer>> ans, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
        } else {
            Set<Integer> appeared = new HashSet<>();
            for (int i = index; i < nums.length; ++i) {
                if (!appeared.contains(nums[i])) {
                    appeared.add(nums[i]);
                    swap(nums, index, i);
                    permute(ans, nums, index + 1);
                    swap(nums, index, i);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}