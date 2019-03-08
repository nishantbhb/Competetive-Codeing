package com.nishant.algo;

import java.util.Stack;

public class PostFixEval {


    static int evalRPN(String[] tokens) {
        if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        Stack<Integer> numStack = new Stack<>();
        numStack.push(Integer.parseInt(tokens[0]));
        int i = 1;
        while (i < tokens.length) {
            try {
                int a = Integer.parseInt(tokens[i]);
                numStack.push(a);
            } catch (NumberFormatException e) {
                String op = tokens[i];
                int y = numStack.pop();
                int x = numStack.pop();
                switch (op) {
                    case "+":
                        numStack.push(x + y);
                        break;
                    case "-":
                        numStack.push(x - y);
                        break;
                    case "*":
                        numStack.push(x * y);
                        break;
                    case "/":
                        numStack.push(x / y);
                        break;
                    default:
                        break;

                }
            }
            i++;
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

    }

}