package com.nishant.algo;

import java.util.Arrays;

public class NextHighTemperature {

    /*[73,74,75,71,69,72,76,73]
            [1,1,4,2,1,1,0,0]*/

    static int[] dailyTemperatures(int[] T) {
        int size = T.length;
        int[] numDays = new int[size];
        for (int i = size - 2; i >= 0; i--) {
            int p = i + 1;
            //fetch the next large temperature
            while (p < size && T[i] >= T[p] && T[p] != 0) {
                p++;
            }
            //check if a large number is found then update the distance
            if (p < size && T[p] > T[i])
                numDays[i] = p - i;

        }
        return numDays;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));

    }

}