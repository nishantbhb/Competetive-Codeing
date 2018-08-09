package soroco.test.nishant;

import java.util.Scanner;

public class Question4BonusBackup {

    static int numberOfDigits(long N, int B) {
        if (B <= 2)
            return -1;

        long x = N;
        int countOfDigits = 0;

        for (int i = B - 1; i >= 2; i--) {
            if (x % i == 0) {
                countOfDigits++;
                x /= i;
            }
        }
        if (x > B)
            return -1;

        else
            return countOfDigits;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of N: ");
        long N = s.nextLong();
        System.out.println("Enter the value of Base: ");
        int B = s.nextInt();
        System.out.println("Number of digits: " + numberOfDigits(N, B));
        s.close();

    }

}
