package com.nishant.algo;

import java.util.ArrayList;
import java.util.List;

public class BuildParentheses {

    private static void buildParen(int leftRem, int rightRem, List<String> paren, int i, char[] arr) {
        if (leftRem == 0 && rightRem == 0) {
            paren.add(String.valueOf(arr));
            return;
        }

        if (leftRem > 0) {
            arr[i] = '(';
            buildParen(leftRem - 1, rightRem, paren, i + 1, arr);
        }
        if (leftRem < rightRem) {
            arr[i] = ')';
            buildParen(leftRem, rightRem - 1, paren, i + 1, arr);
        }
    }

    public static void main(String[] args) {
        List<String> paren = new ArrayList<>();
        buildParen(3, 3, paren, 0, new char[6]);
        System.out.println(paren);
    }
}
