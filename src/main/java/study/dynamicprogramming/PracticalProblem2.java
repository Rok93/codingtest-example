package study.dynamicprogramming;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PracticalProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][];
        int[][] dpTable = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            dpTable[i] = new int[i + 1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int value = sc.nextInt();
                arr[i][j] = value;
                dpTable[i][j] = value;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                dpTable[i + 1][j] = Math.max(dpTable[i + 1][j], dpTable[i][j] + arr[i + 1][j]);

                if (j + 1 <= i + 1) {
                    dpTable[i + 1][j + 1] = Math.max(dpTable[i + 1][j + 1], dpTable[i][j] + arr[i + 1][j + 1]);
                }
            }
        }

        int max = IntStream.range(0, n)
                .map(index -> dpTable[n - 1][index])
                .max()
                .getAsInt();
        System.out.println(max);
    }
}
