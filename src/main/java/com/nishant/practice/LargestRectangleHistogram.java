package com.nishant.practice;

import java.util.Stack;

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        int max = 0;

        int i;
        for (i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i);
            else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int j = stack.pop();
                    //for length in left till where this height is present
                    int dist = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, heights[j] * dist);
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            //for length in left till where this height is present
            int dist = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, heights[j] * dist);
        }

        return max;

    }


    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{5, 4, 1, 2}));
    }

}
