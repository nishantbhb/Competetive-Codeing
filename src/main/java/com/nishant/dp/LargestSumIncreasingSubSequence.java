package com.nishant.dp;

public class LargestSumIncreasingSubSequence {

    public static void main(String[] args) {
        int arr[] = {4, 6, 1, 3, 8, 4, 6};
        int sum[] = new int[7];
        int seq[] = new int[7];

        for (int i = 0; i < 7; i++) {
            sum[i] = arr[i];
            seq[i] = 0;
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (sum[j] + arr[i] > sum[i]) {
                        sum[i] = sum[j] + arr[i];
                        seq[i] = j;
                        // System.out.println("Sum[" + i + "]=" + sum[i]);
                    }
                }
            }
        }
        int max = 0;
        int ptr = 0;
        for (int i = 0; i < 7; i++)
            if (sum[i] >= max) {
                max = sum[i];
                ptr = i;
            }

        System.out.println("Max sum=" + max);

        System.out.println("Sequence:");
        int i = ptr;
        boolean flag = false;
        while (true) {
            System.out.println(arr[i]);
            i = seq[i];
            if (flag)
                break;
            if (i == 0)
                flag = true;
        }
    }

}
