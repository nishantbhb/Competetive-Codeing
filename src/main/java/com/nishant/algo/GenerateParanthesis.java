package com.nishant.algo;


import java.util.ArrayList;
import java.util.List;

class GenerateParanthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, n, n, "");
        return list;
    }

    private static void helper(List<String> res, int left, int right, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0)
            helper(res, left - 1, right, s + "(");
        if (right > left)
            helper(res, left, right - 1, s + ")");
    }


    /*public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        String s = "";
        paranthesisUtil(s, n * 2, ret);
        int i = 0;
        while (i < ret.size()) {
            if (!removeInvalid(ret, i))
                i++;
        }
        return ret;
    }

    private static boolean removeInvalid(List<String> ret, int index) {
        String s = ret.get(index);
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (brackets.isEmpty() || brackets.pop() != '(') {
                    ret.remove(index);
                    return true;
                }
            } else
                brackets.push(s.charAt(i));
        }
        if (!brackets.isEmpty()) {
            ret.remove(index);
            return true;
        }
        return false;
    }

    private static void paranthesisUtil(String s, int n, List<String> ret) {
        if (n == 0)
            ret.add(s);
        else {
            paranthesisUtil(s + "(", n - 1, ret);
            paranthesisUtil(s + ")", n - 1, ret);
        }
    }*/


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}