package com.nishant.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        if (numRows == 0)
            return pascal;
        Integer[] arr = new Integer[]{1};
        pascal.add(Arrays.asList(arr));
        if (numRows == 1)
            return pascal;
        arr = new Integer[]{1, 1};
        pascal.add(Arrays.asList(arr));
        int level = 3;
        while (level <= numRows) {
            List<Integer> currLevel = new ArrayList<>();
            currLevel.add(1);
            int i = 0;
            while (i < level - 2) {
                currLevel.add(arr[i] + arr[i + 1]);
                i++;

            }

            currLevel.add(1);
            arr = new Integer[currLevel.size()];
            arr = currLevel.toArray(arr);
            pascal.add(currLevel);
            level++;
        }

        return pascal;
    }


    public static void main(String[] args) {

        List<List<Integer>> list = generate(5);
        System.out.println(list);
    }
}
