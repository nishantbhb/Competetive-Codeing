package com.nishant.dp;

//using O(n) extra space, time complexity O(n)
public class MinCostPath {

	static int min(int a, int b, int c) {
		if (a < b) {
			if (a < c)
				return a;
			else
				return c;
		} else {
			if (c < b)
				return c;
			else
				return b;
		}

	}

	static int minCost(int cost[][], int r, int c) {
		
		int temp[][] = new int[cost.length][cost[0].length];
		temp[0][0] = cost[0][0];
		for (int i = 1; i < cost.length; i++)
			temp[i][0] = temp[i - 1][0] + cost[i][0];

		for (int j = 1; j < cost[0].length; j++)
			temp[0][j] = temp[0][j - 1] + cost[0][j];

		for (int i = 1; i <= r; i++)
			for (int j = 1; j <= c; j++)
				temp[i][j] = min(temp[i - 1][j], temp[i][j - 1], temp[i - 1][j - 1]) + cost[i][j];

		return temp[r][c];

	}

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.println("Min cost: " + minCost(cost, 2, 2));

	}
}
