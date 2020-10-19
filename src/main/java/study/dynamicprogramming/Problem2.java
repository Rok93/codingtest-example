package study.dynamicprogramming;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 3 <= N <= 100
        int[] foods = new int[100];
        for (int i = 0; i < N; i++) {
            foods[i] = sc.nextInt(); // 0 <= K <= 1,000
        }

        int sum = 0;
        for (int i = 0; i < N; i += 2) {
            if (foods[i] < foods[i + 1]) {
                sum += foods[i + 1];
                i++;
                continue;
            }

            sum += foods[i];
        }

        System.out.println(sum);
    }
}
