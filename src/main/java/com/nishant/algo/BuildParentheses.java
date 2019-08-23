package com.nishant.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    //unoptimized
    private static Set<String> buildParen(int rem) {
        if (rem == 0) {
            Set<String> paren = new HashSet<>();
            paren.add("");
            return paren;
        }

        Set<String> paren = buildParen(rem - 1);
        Set<String> newParen = new HashSet<>();
        for (String str : paren) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    String newSeq = str.substring(0, i + 1) + "()" + str.substring(i + 1);
                    newParen.add(newSeq);
                }
            }
            newParen.add(str + "()");
        }
        return newParen;
    }



    public static void main(String[] args) {
        List<String> paren = new ArrayList<>();
        buildParen(3, 3, paren, 0, new char[6]);
        System.out.println(paren);

        //unoptimized
        System.out.println(buildParen(3));
    }
}
