package com.nishant.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int num : stones)
            list.add(num);
        int[] maxs;
        while (list.size() > 1) {
            maxs = findMaxs(list);
            Arrays.sort(maxs); // to avoid ArrayIndexOutOfBoundsException
            int a = list.remove(maxs[1]);
            int b = list.remove(maxs[0]);
            if (Math.abs(a - b) > 0)
                list.add(Math.abs(a - b));
        }
        return list.size() > 0 ? list.get(0) : 0;
    }

    int[] findMaxs(List<Integer> list) {
        int max = 0;
        int sec = 1;
        for (int i = 1; i < list.size(); i++) {
            int curr = list.get(i);
            int maxVal = list.get(max);
            int secondVal = list.get(sec);

            if (curr > maxVal) {
                sec = max;
                max = i;
            } else if (curr > secondVal) {
                sec = i;
            }
        }
        return new int[]{max, sec};

    }

}
