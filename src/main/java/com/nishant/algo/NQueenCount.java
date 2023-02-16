package com.nishant.algo;

public class NQueenCount {
    public static int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];

        return countTotalNQueens(board, 0, 0);

    }

    static int countTotalNQueens(boolean[][] board, int col, int count) {
        int n = board.length;
        int row = 0;
        while (row < n) {
            if (col == n)
                return count + 1;
            if (checkValidPosition(board, row, col)) {
                board[row][col] = true;
                count = countTotalNQueens(board, col + 1, count);
            }
            board[row][col] = false;
            row++;
        }
        return count;
    }

    static boolean checkValidPosition(boolean[][] board, int row, int col) {
        return trackDiagonalTop(board, row, col)
                && trackLeft(board, row, col)
                && trackDiagonalDown(board, row, col);
    }

    static boolean trackDiagonalTop(boolean[][] board, int row, int col) {
        row--;
        col--;
        while (row >= 0 && col >= 0) {
            if (board[row][col])
                return false;
            row--;
            col--;
        }
        return true;
    }

    static boolean trackLeft(boolean[][] board, int row, int col) {
        col--;
        while (col >= 0) {
            if (board[row][col])
                return false;
            col--;
        }
        return true;
    }

    static boolean trackDiagonalDown(boolean[][] board, int row, int col) {
        row++;
        col--;
        while (row < board[0].length && col >= 0) {
            if (board[row][col])
                return false;
            row++;
            col--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
