package com.nishant.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PermutationNonDistinctUptoKLength {


    private static List<String> permute(String s, int k) {
        if (s == null)
            return null;

        Map<Character, Integer> charMap = buildCharMap(s);
        List<String> permutes = new ArrayList<>();
        buildPermute(charMap, "", k, permutes);
        return permutes;

    }

    private static void buildPermute(Map<Character, Integer> charMap, String prefix, int rem, List<String> permutes) {
        if (rem == 0) {
            permutes.add(prefix);
            return;
        }

        for (char c : charMap.keySet()) {
            int cnt = charMap.get(c);
            charMap.put(c, cnt - 1);
            buildPermute(charMap, prefix + c, rem - 1, permutes);
            charMap.put(c, cnt);

        }

    }

    private static Map<Character, Integer> buildCharMap(String s) {
        if (s == null || s.length() == 0)
            return new HashMap<>();

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        return charMap;
    }

    public static void main(String[] args) {
        System.out.println(permute("abc", 2));
    }


}


