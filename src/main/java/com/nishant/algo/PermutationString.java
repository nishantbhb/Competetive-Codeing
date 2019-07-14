package com.nishant.algo;

import java.util.HashSet;
import java.util.Set;

//time complexity O(n^2 * n!)
public class PermutationString {

    private static void stringPermutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            Set<Character> visited = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);//to exclude ith char

                char c = str.charAt(i);
                if (!visited.contains(c)) {
                    visited.add(c);
                    stringPermutation(rem, prefix + c);//add ith char
                }
            }
        }
    }

    public static void main(String[] args) {
        stringPermutation("ABC", "");
    }
}
