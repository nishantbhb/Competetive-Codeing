package com.nishant.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
a -> "a"
b -> ba, ab
c -> cba, bca, bac,   cab, acb, abc
 */
public class PermutationDP {

    private static void permute(String str, int curr, ArrayList<ArrayList<String>> dp) {
        if (str == null || str.length() == curr) {
            return;
        }

        ArrayList<String> prev = dp.get(dp.size() - 1);

        Set<String> currPermuteList = new HashSet<>();

        for (String currWord : prev) {
            for (int j = 0; j < currWord.length(); j++) {
                String newPermuteWord = currWord.substring(0, j) + str.charAt(curr) + currWord.substring(j);
                currPermuteList.add(newPermuteWord);

            }
            String newPermuteWord = currWord + str.charAt(curr);// to put at last position
            currPermuteList.add(newPermuteWord);

        }
        dp.add(new ArrayList<>(currPermuteList));
        permute(str, curr + 1, dp);
    }

    private static ArrayList<String> getPermutationStrings(String str) {
        ArrayList<String> zero = new ArrayList<>();
        zero.add("");
        ArrayList<ArrayList<String>> dp = new ArrayList<>();
        dp.add(zero);

        permute(str, 0, dp);

        return dp.get(dp.size() - 1);


    }

    public static void main(String[] args) {

        System.out.println(getPermutationStrings("AAB"));
    }
}
