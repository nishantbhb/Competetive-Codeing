package com.nishant.algo;

public class NQueenProb {
	static int N = 4;
	static int ctr = 0;

	static void printBoard(int board[][]) {
		System.out.println("Result");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}

	static boolean isSafe(int board[][], int row, int col) {

		for (int i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		int i = row;
		int j = col;
		while (i >= 0 && j >= 0)
			if (board[i--][j--] == 1)
				return false;

		i = row;
		j = col;

		while (i < N && j >= 0)
			if (board[i++][j--] == 1)
				return false;

		return true;
	}

	static boolean solveNQUtil(int board[][], int col) {

		if (col == N) {
			ctr++;
			printBoard(board);
			return true;
		}

		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;

				solveNQUtil(board, col + 1);

				board[i][col] = 0;

			}
		}
		if (ctr > 0)
			return false;
		else
			return true;
	}

	static void solveNQ() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		// int board[][] = { { 0, 0 }, { 0, 0 } };

		if (solveNQUtil(board, 0)) {
			System.out.println("Solution does not exist");
		}

		// printBoard(board);

	}

	public static void main(String args[]) {
		solveNQ();
	}
}
