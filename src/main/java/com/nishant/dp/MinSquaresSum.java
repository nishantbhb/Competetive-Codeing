package com.nishant.dp;


//minimum number of square needed to form a sum (n)
public class MinSquaresSum {
    static int numSquares(int n) {
        // Create a dynamic programming table
        // to store sq
        int[] dp = new int[n + 1];

        if (n <= 3)
            return n;
        // getMinSquares table for base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            dp[i] = i;

            for (int k = 1; k < i; k++) {
                int temp = k * k;
                if (temp > i)
                    break;

                dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(numSquares(123));
    }

}