package p20200601;

import java.util.Scanner;

public class Study1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] fibonacciNumbers = new int[41];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;

        for (int i = 2; i < 41; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        int tryNumber = sc.nextInt();

        for (int i = 0; i < tryNumber; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                System.out.println(1 + " " + 0);
                continue;
            }

            if (input == 1) {
                System.out.println(0 + " " + 1);
                continue;
            }
            System.out.println(fibonacciNumbers[input - 1] + " " + fibonacciNumbers[input]);
        }
    }
}
