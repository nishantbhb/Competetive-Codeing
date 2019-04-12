package com.nishant.algo;


class QuickSort {


    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 1, 3, 4, 5};

        quickSort(arr, 0, 5);
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
        int i = l + 1;
        int pivot = arr[l];

        //rearrange the array by putting elements which are less than pivot on one side and which are greater that on other.
        for (int j = l + 1; j <= r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, l, i - 1);//put the pivot element in its proper place.
        return i - 1;//return the position of the pivot
    }

    private static void swap(int[] arr, int i, int largestIndex) {
        int temp = arr[i];
        arr[i] = arr[largestIndex];
        arr[largestIndex] = temp;
    }


}