package com.nishant.algo;

class Sudoku {

    public static void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    private static boolean solveSudoku(char[][] board, int row) {
        RowCol nextRolCol = findNextRowCol(board, row);
        int r = nextRolCol.row;
        int c = nextRolCol.col;
        if (r == 9 && c == 9)
            return true;

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, num, r, c)) {
                board[r][c] = num;
                if (solveSudoku(board, r)) {
                    return true;
                }
            }
            board[r][c] = '.';
        }
        return false;
    }

    private static RowCol findNextRowCol(char[][] board, int row) {
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.') {
                    return new RowCol(i, j);
                }
        }
        return new RowCol(9, 9);
    }

    private static boolean isValid(char[][] board, char c, int row, int col) {
        return checkRow(board, c, row) && checkColumn(board, c, col) && checkGrid(board, c, row, col);
    }

    private static boolean checkRow(char[][] board, char c, int row) {
        for (int i = 0; i < 9; i++)
            if (board[row][i] == c)
                return false;
        return true;
    }

    private static boolean checkColumn(char[][] board, char c, int col) {
        for (int i = 0; i < 9; i++)
            if (board[i][col] == c)
                return false;
        return true;
    }

    private static boolean checkGrid(char[][] board, char c, int row, int col) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c)
                    return false;
            }
        return true;
    }

    public static void main(String[] args) {
        char[][] array = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {
                '6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {
                '8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {
                '7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {
                '.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(array);
    }

    static class RowCol {

        int row;
        int col;

        RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}


