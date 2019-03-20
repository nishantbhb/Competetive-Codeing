package com.nishant.algo;


class LicensePlate {
    static public String licenseKeyFormatting(String S, int K) {

        StringBuilder sb = new StringBuilder();
        int ctr = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (ctr == K) {

                sb.insert(0, '-');
                ctr = 0;
            }
            if (S.charAt(i) == '-') {
                continue;
            }

            sb.insert(0, S.charAt(i));
            ctr++;

        }

        String str = sb.toString().toUpperCase();
        int i = 0;
        while (i < str.length() && str.charAt(i) == '-') {
            str = str.substring(i + 1);
        }
        return str;

    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}