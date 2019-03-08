package com.nishant.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//valid bracket
public class ValidBracketSequence {

    static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('{', '}');
        charMap.put('[', ']');

        for (char c : s.toCharArray()) {
            if (charMap.containsKey(c))
                stack.push(charMap.get(c));
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != c)
                    return false;
            }


        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));

    }

}