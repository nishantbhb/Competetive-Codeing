package com.nishant.algo;


import java.util.ArrayList;
import java.util.List;

class DistinctPermutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num))
                    continue; // element already exists, skip

                tempList.add(num);
                backtrack(list, tempList, nums);

                tempList.remove(tempList.size() - 1);// remove the last element added in tempList
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{0, 1, 2}));
    }
}