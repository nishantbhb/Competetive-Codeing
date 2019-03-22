package com.nishant.algo;


class LengthLongestPath {
    static int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        int max = 0;
        int[] level = new int[tokens.length + 1];
        for (String dir : tokens) {
            int index = dir.lastIndexOf("\t") + 1;
            level[index + 1] = level[index] + dir.length() - index + 1;
            if (dir.contains(".")) {
                max = Math.max(level[index + 1] - 1, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}