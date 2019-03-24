package com.nishant.algo;


import java.util.HashMap;
import java.util.Map;

class RomanToDecimal {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int m = s.length();
        int sum = map.get(s.charAt(m - 1));
        for (int i = m - 2; i >= 0; i--) {
            int x = map.get(s.charAt(i));
            int y = map.get(s.charAt(i + 1));
            sum = (x >= y) ? sum + x : sum - x;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}