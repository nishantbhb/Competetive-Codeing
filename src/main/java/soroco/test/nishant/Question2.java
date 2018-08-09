package soroco.test.nishant;

import java.util.Scanner;

public class Question2 {

    static int numberOfDigits(long N) {
        if (N % 2 != 0 && N % 3 != 0 && N % 5 != 0 && N % 7 != 0)
            return -1;

        int f2 = 0;
        int f3 = 0;
        int f5 = 0;
        int f7 = 0;

        long x = N;

        while (x >= 2) {
            if (x % 2 == 0) {
                f2++;
                x /= 2;
            } else if (x % 3 == 0) {
                f3++;
                x /= 3;
            } else if (x % 5 == 0) {
                f5++;
                x /= 5;
            } else if (x % 7 == 0) {
                f7++;
                x /= 7;
            } else
                break;
        }

        if (x > 7)
            return -1;

        else {
            if (f2 >= 3) {
                int rem = f2 % 3;
                int quo = f2 / 3;
                if (rem == 2)
                    f2 = rem + quo - 1;
                else
                    f2 = rem + quo;
            } else if (f2 == 2)
                f2--;

            if (f3 >= 2) {
                int rem = f3 % 2;
                int quo = f3 / 2;

                f3 = rem + quo;
            }

            return f2 + f3 + f5 + f7;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N: ");
        long N = s.nextLong();
        System.out.println("Number of digits: " + numberOfDigits(N));
        s.close();

    }

}
