package com.nishant.algo;

import java.util.Scanner;

public class LargeFactorial {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number:");
        int n = s.nextInt();
        int fact[] = new int[10000];
        fact[0] = 1;
        int size = 1;
        int carry = 0;
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < size; i++) {
                int prod = fact[i] * j + carry;
                fact[i] = prod % 10;
                carry = prod / 10;
            }
            if (carry > 0)
                while (carry > 0) {
                    fact[size] = carry % 10;
                    carry /= 10;
                    size++;

                }
        }

        for (int i = size - 1; i >= 0; i--)
            System.out.print(fact[i]);
        s.close();

    }

}
