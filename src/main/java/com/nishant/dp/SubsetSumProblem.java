package com.nishant.dp;

//works if only one subset exists as it fails during printing the subset

public class SubsetSumProblem {

    static boolean isSubsetSum(int set[], int n, int sum) {

        boolean check[][] = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++)
            check[i][0] = true;

        for (int i = 1; i < sum + 1; i++)
            if (i == set[0])
                check[0][i] = true;
            else
                check[0][i] = false;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (set[i] > j)
                    check[i][j] = check[i - 1][j];
                else
                    check[i][j] = (check[i - 1][j] || check[i - 1][j - set[i]]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum + 1; j++)
                System.out.print(check[i][j] + " ");
            System.out.println();
        }

        if (check[n - 1][sum]) {
            int col = sum;
            int row = n - 1;
            while (true) {
                if (col == 0)
                    break;
                if (!check[row - 1][col]) {
                    System.out.print(set[row] + " ");
                    col = col - set[row];
                    row--;
                } else {
                    row--;
                }
            }

            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        int set[] = {2, 3, 7, 8, 10};
        int sum = 11;
        int n = set.length;
        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }

}
