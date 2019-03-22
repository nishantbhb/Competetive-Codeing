package com.nishant.algo;


class LengthLongestPath {
    static int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String s : paths) {
            int len = s.lastIndexOf("\t") + 1;
            int curLen = stack[len] + s.length() - len + 1; //extra 1 may be for "/" in path
            stack[len + 1] = curLen;
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}