package com.nishant.dp;


class LongestParenthesesDP {


  public static int longestValidParentheses(String s) {
    int[] dp = new int[s.length()];
    int left = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else if (left > 0) {
        dp[i] = dp[i - 1] + 2;
        dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
        max = Math.max(max, dp[i]);
        left--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestValidParentheses("(()"));
  }
}