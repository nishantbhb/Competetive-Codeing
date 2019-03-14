package com.nishant.algo;


/*
Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
 */
class KthStringGrammar {
    static int kthGrammar(int N, int K) {
        return kthGrammar(K - 1);

    }

    static int kthGrammar(int K) {
        if (K == 0)
            return 0;


        int val = kthGrammar(K / 2);
        if (val == 0) {
            if (K % 2 == 1)
                return 1;
            else
                return 0;
        } else {
            if (K % 2 == 1)
                return 0;
            else
                return 1;
        }

    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(30, 434991989));
    }


}
