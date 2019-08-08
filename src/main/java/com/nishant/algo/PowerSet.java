package com.nishant.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * generates powerset of the given set.
 */
public class PowerSet {

    public static void main(String[] args) {
        List<List<Integer>> powerSet = new ArrayList<>();
        int[] arr = new int[]{1, 2, 3, 4};
        findPowerSet(arr, 0, powerSet, new ArrayList<>());
        System.out.println(powerSet);
    }

    private static void findPowerSet(int[] arr, int i, List<List<Integer>> powerSet, List<Integer> curr) {
        if (i == arr.length) {
            powerSet.add(curr);
            return;
        }

        List<Integer> excludingCurrIndex = new ArrayList<>(curr);
        findPowerSet(arr, i + 1, powerSet, excludingCurrIndex);

        List<Integer> includingCurrIndex = new ArrayList<>(curr);
        includingCurrIndex.add(arr[i]);
        findPowerSet(arr, i + 1, powerSet, includingCurrIndex);
    }
}
