package com.nishant.algo;

public class PrintIncDecSequence {

    public static void main(String[] args) {
        String seq = "DDIDDIID";
        int n = seq.length();
        int arr[] = new int[n + 1];
        // System.out.println(n);
        int min_avail = 1, pos_of_I = 0;
        if (seq.charAt(0) == 'I') {
            arr[0] = 1;
            arr[1] = 2;
            min_avail = 3;
            pos_of_I = 1;
        } else {
            arr[0] = 2;
            arr[1] = 1;
            min_avail = 3;
            pos_of_I = 0;
        }
        for (int i = 1; i < n; i++) {
            if (seq.charAt(i) == 'I') {
                arr[i + 1] = min_avail;
                pos_of_I = i + 1;
                min_avail++;
            } else {
                arr[i + 1] = arr[i];
                for (int j = pos_of_I; j <= i; j++)
                    arr[j]++;
                min_avail++;
            }
        }
        for (int i : arr)
            System.out.println(i);

    }

}
