package com.nishant.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TokenizeString {


    private static String[] tokenize_string(String S) {

        // Write your code here

        List<String> words = new ArrayList<>();

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < S.length()) {
            if (S.charAt(i) == '\"') {
                sb = new StringBuilder();
                sb.append(S.charAt(i)); //initial "
                i++;
                while (S.charAt(i) != '\"') {
                    sb.append(S.charAt(i));
                    i++;
                }
                sb.append(S.charAt(i)); // for ending "
                words.add(sb.toString());
                sb = new StringBuilder();
                i += 2;//for skipping next space
                continue;
            }
            if (S.charAt(i) == ' ') {
                words.add(sb.toString());
                sb = new StringBuilder();
                i++;
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        if (S.charAt(S.length() - 1) != '\"') {
            words.add(sb.toString()); //if last word is not in quotes
        }

        String[] wordArray = new String[words.size()];
        wordArray = words.toArray(wordArray);

        return wordArray;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                tokenize_string("xyz abc mnp \"asdf dfaa asdf\" asd \"fdas asdsdafF\" ABC")));
    }
}


