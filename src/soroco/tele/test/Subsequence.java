package soroco.tele.test;

import java.util.Scanner;

public class Subsequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no. of elements in sequence:");
		int n = s.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter space separated sequence values:");
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		int ctr = 0;
		int currCtr = 1;
		// int flag = 0;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] > arr[i]) {
				currCtr++;

			} else {
				ctr += ((currCtr * (currCtr - 1)) / 2);
				currCtr = 1;
			}

		}

		if (currCtr > 1) {
			ctr += ((currCtr * (currCtr - 1)) / 2);
		}

		System.out.println("Total count: " + ctr);

		s.close();

	}

}
