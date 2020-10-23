package p20201023;

import java.util.Scanner;

public class Problem1 {

    // 2839번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 설탕 봉지는 3kg, 5kg 있다.
        int N = sc.nextInt();

        int sum = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                sum += N / 5;
                N %= 5;
                break;
            }

            N -= 3;
            sum++;
        }

        if (N != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
    }
}
