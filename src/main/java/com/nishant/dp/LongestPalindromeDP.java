package com.nishant.dp;


class LongestPalindromeDP {


    public static String longestPalindrome(String s) {
        if (s == null)
            return "";
        int n = s.length();
        if (n == 0)
            return "";
        int maxLen = 0;
        int palindromeStart = 0;
        //indicates whether substring s starting at index i and ending at j is palindrome
        boolean[][] palindrome = new boolean[n][n];
        palindrome[0][0] = true;

        // find the max palindrome within this window of (j,i)
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {

                //check if substring between (j,i) is palindrome
                // chars at i and j should match
                // if window is less than 3, just end chars should match e.g. i = 0,  j= 1,2
                // if window is > 3, substring (i-1, j+1) should be palindrome too
                if ((s.charAt(i) == s.charAt(j)) && (i - j < 3 || palindrome[i - 1][j + 1])) {
                    palindrome[i][j] = true;
                    //update max palindrome string
                    if (maxLen < i - j + 1) {
                        maxLen = i - j + 1;
                        palindromeStart = j;
                    }
                }

            }
        }
        return s.substring(palindromeStart, palindromeStart + maxLen);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("aBaBaDcdcdcD"));
    }
}