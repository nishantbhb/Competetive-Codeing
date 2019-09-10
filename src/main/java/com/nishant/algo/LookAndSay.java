package com.nishant.algo;


import java.util.Scanner;

class LookAndSay {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */


        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n = s.nextInt();

        System.out.println(lookAndSay(str, n));
        s.close();

    }

    private static String lookAndSay(String str, int n) {
        if (n == 0)
            return str;
        int ctr = 1;
        char prev = str.charAt(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == prev) {
                ctr++;
                continue;
            }
            sb.append(ctr);
            sb.append(prev);

            prev = c;
            ctr = 1;

        }
        sb.append(ctr);
        sb.append(prev);

        return lookAndSay(sb.toString(), n - 1);
    }
}


