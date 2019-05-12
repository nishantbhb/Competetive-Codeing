package com.nishant.algo;

import java.util.Arrays;

public class IncreasingDecreasingSeq {
    private static int[] diStringMatchOtherWay(String S) {
        int n = S.length();
        int[] arr = new int[n + 1];
        int min = 0;
        int max = n;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I') {
                arr[i] = min;
                min++;
            } else {
                arr[i] = max;
                max--;
            }
        }

        arr[n] = max; //last element will be the only value left (min=max)
        return arr;
    }

    private static int[] diStringMatch(String S) {
        int n = S.length();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I')
                arr[i + 1] = arr[i] + 1;
            else
                arr[i + 1] = arr[i];
        }

        int largest = arr[n];
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == 'D') {
                arr[i] = largest + 1;
                largest++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatchOtherWay("IDID")));
    }

}
