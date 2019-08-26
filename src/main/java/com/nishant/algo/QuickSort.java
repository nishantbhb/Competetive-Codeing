package com.nishant.algo;


class QuickSort {


    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 6, 7, 1, 3, 4, 5};

        quickSort(arr, 0, 7);
        // Write your code here
        for (int a : arr) {
            System.out.println(a);
        }


    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }

    }


    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;

        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int largestIndex) {
        int temp = arr[i];
        arr[i] = arr[largestIndex];
        arr[largestIndex] = temp;
    }


}