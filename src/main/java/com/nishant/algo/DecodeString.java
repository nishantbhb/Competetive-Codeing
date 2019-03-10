package com.nishant.algo;

import java.util.Stack;

public class DecodeString {

    static String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;

        char[] characters = s.toCharArray();
        int i = characters.length - 1;

        Stack<Character> stack = new Stack<>();

        while (i >= 0) {

            if (characters[i] == '[') {
                StringBuilder decoded = new StringBuilder();
                i--;
                StringBuilder digits = new StringBuilder();
                while (i >= 0 && characters[i] - '0' >= 0 && characters[i] - '0' <= 9) {
                    char d = characters[i];
                    digits.insert(0, d);
                    i--;
                }
                int k = Integer.parseInt(digits.toString());
                StringBuilder subString = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != ']')
                    subString.append(stack.pop());
                while (k > 0) {
                    decoded.insert(0, subString);
                    k--;
                }
                if (!stack.isEmpty())
                    stack.pop();//remove']'
                for (int j = decoded.length() - 1; j >= 0; j--)
                    stack.push(decoded.charAt(j));
            } else
                stack.push(characters[i--]);

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();


    }

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }

}