package com.nishant.algo;


class HeapSort {


    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};

        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n - 1);
        }

        for (int i = n - 1; i >= 0; i--) {

            swap(arr, i, 0);

            heapify(arr, 0, i - 1);

        }

        // Write your code here
        for (int a : arr) {
            System.out.println(a);
        }


    }

    private static void heapify(int[] arr, int i, int n) {
        int largestIndex = i;
        int lChild = 2 * i + 1;
        int rChild = lChild + 1;

        if (lChild <= n) {
            largestIndex = arr[largestIndex] < arr[lChild] ? lChild : largestIndex;
        }

        if (rChild <= n) {
            largestIndex = arr[largestIndex] < arr[rChild] ? rChild : largestIndex;
        }

        if (largestIndex != i) {
            swap(arr, i, largestIndex);
            heapify(arr, largestIndex, n);
        }

    }

    private static void swap(int[] arr, int i, int largestIndex) {
        int temp = arr[i];
        arr[i] = arr[largestIndex];
        arr[largestIndex] = temp;
    }


}