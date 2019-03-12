package com.nishant.algo;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangleRecursion {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                currRow.add(generatePascal(i, j));
            }
            pascal.add(currRow);
        }
        return pascal;

    }

    int generatePascal(int i, int j) {
        if (j == 0 || j == i)
            return 1;
        return generatePascal(i - 1, j - 1) + generatePascal(i - 1, j);

    }

}
