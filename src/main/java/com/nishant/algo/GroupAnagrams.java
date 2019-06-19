package com.nishant.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anMap = new HashMap<>();

        for (String word : words) {
            int[] letterFreq = new int[26];
            for (char c : word.toCharArray()) {
                letterFreq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                int freq = letterFreq[i];
                int cnt = 0;
                while (cnt < freq) {
                    sb.append((char) (65 + i));
                    cnt++;
                }

            }
            String key = sb.toString();
            List<String> anagrams = anMap.get(key);
            if (anagrams == null)
                anagrams = new ArrayList<>();
            anagrams.add(word);

            anMap.put(key, anagrams);
        }
        return new ArrayList<>(anMap.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
