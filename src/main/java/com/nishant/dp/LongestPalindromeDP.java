package com.nishant.dp;


class LongestPalindromeDP {


    public static String longestPalindrome(String s) {
        int n = s.length();
        int palindromeStartsAt = 0, maxLen = 0;

        boolean[][] dp = new boolean[n][n];
        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome

        for (int i = n - 1; i >= 0; i--) { // keep increasing the possible palindrome string
            for (int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)

                //check if substring between (i,j) is palindrome
                dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
                        &&
                        (j - i < 3  // if window is less than 3, just end chars should match e.g. i = 0,  j= 1,2
                                || dp[i + 1][j - 1]); // if window is > 3, substring (i+1, j-1) should be palindrome too

                //update max palindrome string
                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt + maxLen);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("aBaBaDcdcdcD"));
    }
}