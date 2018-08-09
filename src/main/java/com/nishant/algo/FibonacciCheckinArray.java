package com.nishant.algo;

import java.util.Scanner;

public class FibonacciCheckinArray {

    static boolean isPerfectSquare(double x) {
        int s = (int) Math.sqrt(x);
        double y = s * s;
        return x == y;
    }

    static boolean isFibo(int arr[], int n) {
        for (int i = 0; i < n; i++)
            if (!(isPerfectSquare(5 * arr[i] * arr[i] + 4) || isPerfectSquare(5 * arr[i] * arr[i] - 4)))
                return false;
        return true;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = s.nextInt();
        System.out.println("Enter the array:");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();

        if (isFibo(arr, n)) {
            System.out.println("Fibonacci series");
            System.out.println("Next Element: " + (arr[n - 2] + arr[n - 1]));
        } else
            System.out.println("Not a Fibonacci series");

        s.close();

    }

}
