package p20200721;

import java.util.Scanner;

public class Problem1 {

    public static final int TOTAL_COMPUTOR_NUMBER = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNumber = sc.nextInt();

        for (int i = 0; i < testCaseNumber; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(calculateRestOfAPowB(a, b));
        }
    }

    private static long calculateRestOfAPowB(int a, int b) {
        int number = 1;

        for (int i = 0; i < b; i++) {
            number *= a;
            number %= TOTAL_COMPUTOR_NUMBER;
        }
        return number == 0 ? 10 : number;
    }
}
