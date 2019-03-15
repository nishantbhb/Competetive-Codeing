package com.nishant.algo;

public class CountBSTs {
    static int countBSTs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i] += arr[i - j] * arr[j - 1];
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(countBSTs(4));
    }
}
