package com.nishant.dp;

import java.util.Scanner;

public class FiboMemoization {

	static int calFibo(int n, int arr[]) {

		if (arr[n] == -1) {
			if (n <= 1)
				arr[n] = n;
			else
				arr[n] = calFibo(n - 1, arr) + calFibo(n - 2, arr);
		}
		return arr[n];

	}

	static int fibo(int n) {

		int arr[] = new int[n + 1];
		// initialize to -1
		for (int i = 0; i <= n; i++)
			arr[i] = -1;

		calFibo(n, arr);

		return arr[n];
	}

	public static void main(String[] args) {
		System.out.print("Enter the value of n:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.print("The " + n + "th Fibonacci number is: " + fibo(n));

		s.close();

	}

}
