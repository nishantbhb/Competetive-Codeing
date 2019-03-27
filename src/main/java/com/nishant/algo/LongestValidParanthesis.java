package com.nishant.algo;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class LongestValidParanthesis {


    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int maxLen = 0;

        Map<String, Integer> isValidSequence = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String seq = s.substring(i, j + 1);
                if (!isValidSequence.containsKey(seq)) {
                    int len = j - i + 1;
                    if (isValid(seq)) {
                        maxLen = (maxLen > len) ? maxLen : len;
                    }
                    isValidSequence.put(seq, len);
                }
            }
        }

        for (int i = s.length() - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                String seq = s.substring(j, i + 1);
                if (!isValidSequence.containsKey(seq)) {
                    int len = i - j + 1;
                    if (isValid(seq)) {
                        maxLen = (maxLen > len) ? maxLen : len;
                    }
                    isValidSequence.put(seq, len);
                }
            }
        }
        return maxLen;
    }

    static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');

        for (char c : s.toCharArray()) {
            if (charMap.containsKey(c))
                stack.push(charMap.get(c));
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != c)
                    return false;
            }


        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }
}