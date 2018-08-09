package com.nishant.algo;

import java.util.HashMap;
import java.util.Map;

public class AnagramLetterChange {

    public static void main(String[] args) {

        String a = "team";
        String b = "sdtw";

        if (a.length() == b.length()) {
            Map<Character, Integer> mp1 = new HashMap<>();
            Map<Character, Integer> mp2 = new HashMap<>();
            for (int j = 0; j < a.length(); j++) {
                if (mp1.containsKey(a.charAt(j))) {
                    int x = mp1.get(a.charAt(j));
                    x++;
                    mp2.put(a.charAt(j), x);
                } else {
                    mp1.put(a.charAt(j), 1);
                }
                if (mp2.containsKey(b.charAt(j))) {
                    int x = mp2.get(b.charAt(j));
                    x++;
                    mp2.put(b.charAt(j), x);
                } else {
                    mp2.put(b.charAt(j), 1);
                }
            }
            int ctr = 0;
            for (Map.Entry<Character, Integer> mp : mp1.entrySet()) {
                char x = mp.getKey();
//				System.out.println(x);
                int y = mp.getValue();
                if (!mp2.containsKey(x)) {
//					int z = mp2.get(x);
//					ctr += Math.abs(y - z);
                    ctr += y;
                }

//				System.out.println(ctr);
            }
            System.out.println(ctr);
        } else {
            System.out.println("-1");
        }

    }

}
