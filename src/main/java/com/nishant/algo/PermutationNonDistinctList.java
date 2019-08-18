package com.nishant.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PermutationNonDistinctList {

    private static List<String> permute(String s, String prefix, List<String> permutes) {
        if (s == null || permutes == null)
            return null;

        if (s.length() == 0) {
            permutes.add(prefix);
            return permutes;
        }

        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String rem = s.substring(0, i) + s.substring(i + 1);

            if (!visited.contains(c)) {
                visited.add(c);
                permute(rem, prefix + c, permutes);
            }
        }
        return permutes;

    }

    public static void main(String[] args) {
        System.out.println(permute("aab", "", new ArrayList<>()));
    }


}


