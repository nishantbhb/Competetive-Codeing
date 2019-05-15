package com.nishant.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharactersNonDistinct {

    public List<String> commonChars(String[] A) {
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);
        for (String a : A) {
            int[] currCnt = new int[26];
            for (int i = 0; i < a.length(); i++) {
                currCnt[a.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq[i] = Math.min(freq[i], currCnt[i]);
            }
        }

        List<String> repeats = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            while (freq[i - 'a'] > 0) {
                repeats.add(String.valueOf(i));
                freq[i - 'a']--;
            }
        }
        return repeats;
    }


}
