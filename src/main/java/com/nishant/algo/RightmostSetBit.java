package com.nishant.algo;

import java.util.Scanner;

public class RightmostSetBit {

    public static void main(String[] args) {
        int INT_SIZE = 32;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n > 0) {
            int num = s.nextInt();
            int pos = 1;
            // counting the position of first set bit
            for (int i = 0; i < INT_SIZE; i++) {
                if ((num & (1 << i)) == 0)
                    pos++;

                else
                    break;
            }
            if (pos > 32)
                pos = 0;
            System.out.println(pos);

            n--;
        }

    }
}


