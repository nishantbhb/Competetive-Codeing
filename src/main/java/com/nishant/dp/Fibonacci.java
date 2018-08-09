package com.nishant.dp;

import java.util.Scanner;

public class Fibonacci {

    static int fibo(int n) {

        if (n <= 1)
            return n;

        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.print("Enter the value of n:");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.print("The " + n + "th Fibonacci number is: " + fibo(n));

        s.close();

    }

}
