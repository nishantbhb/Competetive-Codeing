package com.nishant.algo;


import java.util.ArrayList;
import java.util.List;

class Subsets {

    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null) {
            return subsets;
        }

        dfsHelper(nums, new ArrayList<>(), 0, subsets);
        return subsets;
    }

    private void dfsHelper(int[] nums, List<Integer> currSubset, int startIndex, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currSubset));
        for (int i = startIndex; i < nums.length; i++) {
            currSubset.add(nums[i]);
            dfsHelper(nums, currSubset, i + 1, subsets);
            currSubset.remove(currSubset.size() - 1);
        }
    }*/


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null)
            return subsets;

        createSubsets(nums, 0, subsets, new ArrayList<>());

        return subsets;
    }

    private static void createSubsets(int[] nums, int index, List<List<Integer>> subsets, List<Integer> currSubset) {

        subsets.add(currSubset);
        for (int i = index; i < nums.length; i++) {
            List<Integer> newSubset = new ArrayList<>(currSubset);
            newSubset.add(nums[i]);
            createSubsets(nums, i + 1, subsets, newSubset);
        }


    }


    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
    }
}