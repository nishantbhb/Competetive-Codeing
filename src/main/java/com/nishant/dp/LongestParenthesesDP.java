package com.nishant.dp;


class LongestParenthesesDP {


  public static int longestValidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int maxans = 0;

    int[] len = new int[s.length() + 1];

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          if (i >= 2) {
            len[i] = len[i - 2] + 2;
          } else {
            len[i] = 2;
          }
        } else if (i - len[i - 1] > 0 && s.charAt(i - len[i - 1] - 1) == '(') {
          len[i] = len[i - 1] + ((i - len[i - 1]) >= 2 ? len[i - len[i - 1] - 2] : 0) + 2;
        }
        maxans = Math.max(maxans, len[i]);
      }
    }
    return maxans;
  }

  public static void main(String[] args) {
    System.out.println(longestValidParentheses("(()"));
  }
}