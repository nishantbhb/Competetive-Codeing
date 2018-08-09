package soroco.test.nishant;

import java.util.Scanner;

public class Question3 {

    static int trailingZeroes(int N, int x, int y) {
        if ((x % 2 != 0 && y % 2 != 0) || (x % 5 != 0 && y % 5 != 0))
            return 0;
        if (N > 40)
            return -1;

//		if (N == 1)
//			return x;
//		if (N == 2)
//			return y;

        int pre2 = 0;
        int pre5 = 0;
        int curr2 = 0;
        int curr5 = 0;

        int m = x;
        int n = y;

        if (m % 2 == 0) {
            while (m >= 2) {
                if (m % 2 == 0) {
                    pre2++;
                    m /= 2;
                } else
                    break;
            }
        }

        m = x;

        if (m % 5 == 0) {
            while (m >= 5) {
                if (m % 5 == 0) {
                    pre5++;
                    m /= 5;
                } else
                    break;
            }
        }

        if (n % 2 == 0) {
            while (n >= 2) {
                if (n % 2 == 0) {
                    curr2++;
                    n /= 2;
                } else
                    break;
            }
        }

        n = y;

        if (n % 5 == 0) {
            while (n >= 5) {
                if (n % 5 == 0) {
                    curr5++;
                    n /= 5;
                } else
                    break;
            }
        }

        for (int i = 2; i <= N; i++) {
            int temp2 = curr2 + pre2;
            int temp5 = curr5 + pre5;
            pre2 = curr2;
            pre5 = curr5;
            curr2 = temp2;
            curr5 = temp5;
        }

        if (curr5 > curr2)
            return curr2;
        else
            return curr5;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N: ");
        int N = s.nextInt();
        System.out.println("Enter the value of S(0): ");
        int x = s.nextInt();
        System.out.println("Enter the value of S(1): ");
        int y = s.nextInt();
        int num0fTrailingZeroes = trailingZeroes(N, x, y);
        System.out.println("Number of trailing zeroes: " + num0fTrailingZeroes);

        s.close();

    }

}
