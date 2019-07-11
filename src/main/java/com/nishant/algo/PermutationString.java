package com.nishant.algo;

//time complexity O(n^2 * n!)
public class PermutationString {

    private static void stringPermutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);//to exclude ith char
                stringPermutation(rem, prefix + str.charAt(i));//add ith char
            }
        }
    }

    public static void main(String[] args) {
        stringPermutation("ABCD", "");
    }
}
