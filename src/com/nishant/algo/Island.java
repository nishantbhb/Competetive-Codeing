package com.nishant.algo;

import java.util.Scanner;

//if previous row and column are not 1 then increase island counter, 
//in case of inverted L like shape check if both previous row and column are 1 
//and previous diagonal cell is 0 then decrease counter
public class Island {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = 5, n = 5;
		int ctr = 0;
		int mat[][] = { { 1, 1, 0, 0, 0 }, 
						{ 0, 1, 0, 0, 1 }, 
						{ 1, 0, 0, 1, 1 }, 
						{ 0, 0, 0, 0, 0 }, 
						{ 1, 0, 1, 0, 1 } };

		if (mat[0][0] == 1)
			ctr++;

		for (int i = 1; i < m; i++) {
			if (mat[i][0] == 1)
				if (mat[i - 1][0] != 1)
					ctr++;
		}

		for (int j = 1; j < n; j++) {
			if (mat[0][j] == 1)
				if (mat[0][j - 1] != 1)
					ctr++;
		}
		System.out.println(ctr);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][j] == 1) {
					if (mat[i - 1][j] != 1 && mat[i][j - 1] != 1) {
						ctr++;
					}

					if (mat[i - 1][j] == 1 && mat[i][j - 1] == 1) {
						if (mat[i - 1][j - 1] != 1)
							ctr--;
					}
				}
				System.out.println(ctr);
			}
			System.out.println();
		}
		System.out.println("Number of islands: " + ctr);

		s.close();
	}

}
