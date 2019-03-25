package com.nishant.algo;


class Abbreviation {
//partial test-cases pass


    static String abbreviation(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        if (A.length == 0 && B.length != 0)
            return "NO";

        int j = 0;
        int i = 0;
        while (i < B.length && j < A.length) {

            while (j < A.length && Character.toUpperCase(A[j]) != B[i]) {
                if (A[j] != B[i] && Character.isUpperCase(A[j]))
                    return "NO";
                j++;
            }
            i++;
            j++;
        }

        if (i == B.length) {
            if (j == A.length)
                return "YES";
            else if (j > A.length)
                return "NO";
            else {
                while (j < A.length) {
                    if (Character.isUpperCase(A[j]))
                        return "NO";
                    j++;
                }
                return "YES";
            }
        }
        return "NO";

    }


    public static void main(String[] args) {
        System.out.println(abbreviation("sYOCa", "YOCN"));
    }
}