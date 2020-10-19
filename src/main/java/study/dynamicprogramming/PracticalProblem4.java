package study.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class PracticalProblem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dt = new int[n];
        Arrays.fill(dt, 1);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dt[i] = Math.max(dt[i], dt[j] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dt));
        int maxLen = Arrays.stream(dt)
                .max()
                .getAsInt();

        System.out.println(n - maxLen);
    }
}

/*
7
15 11 4 8 5 2 4
 */
