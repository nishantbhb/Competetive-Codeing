package com.nishant.graph;

public class KthOptimalGraph {

    static int min(int a, int b, int c) {
        if (a < b) {
            if (a < c)
                return a;
            else
                return c;
        } else {
            if (c < b)
                return c;
            else
                return b;
        }

    }

    static int minCost(int cost[][], int r, int c) {
        if (r < 0 || c < 0)
            return 999999;
        else if (r == 0 && c == 0)
            return cost[r][c];
        else
            return min(minCost(cost, r - 1, c), minCost(cost, r, c - 1), minCost(cost, r - 1, c - 1)) + cost[r][c];

    }

    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};

        System.out.println("Min cost: " + minCost(cost, 2, 2));

    }

}
