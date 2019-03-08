package com.nishant.algo;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> stack;
    int minIndex;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayList<>();
        minIndex = -1;
    }

    public void push(int x) {
        stack.add(x);
        if (minIndex == -1)
            minIndex = 0;
        else
            minIndex = stack.get(minIndex) > x ? stack.size() - 1 : minIndex;
    }

    public void pop() {
        if (stack.size() - 1 == minIndex) {
            minIndex = 0;
            for (int i = 0; i < stack.size() - 1; i++) {
                minIndex = stack.get(i) < stack.get(minIndex) ? i : minIndex;
            }
        }
        if (!stack.isEmpty())
            stack.remove(stack.size() - 1);


    }

    public int top() {
        if (!stack.isEmpty())
            return stack.get(stack.size() - 1);
        return -1;
    }

    public int getMin() {
        if (!stack.isEmpty())
            return stack.get(minIndex);
        return -1;
    }
}

