package study.dynamicprogramming;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PracticalProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] goldMines = new int[n][m];
            int[][] dpTable = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int value = sc.nextInt();
                    goldMines[j][k] = value;
                    dpTable[j][k] = value;
                }
            }

            for (int j = 0; j < m - 1; j++) {
                for (int k = 0; k < n; k++) {
                    // 오른쪽 한칸
                    dpTable[k][j + 1] = Math.max(dpTable[k][j] + goldMines[k][j + 1], dpTable[k][j + 1]);
                    // 오른쪽 아래
                    if (k + 1 < n) {
                        dpTable[k + 1][j + 1] = Math.max(dpTable[k][j] + goldMines[k + 1][j + 1], dpTable[k + 1][j + 1]);
                    }
                    // 오른쪽 위
                    if (k - 1 >= 0) {
                        dpTable[k - 1][j + 1] = Math.max(dpTable[k][j] + goldMines[k - 1][j + 1], dpTable[k - 1][j + 1]);
                    }
                }
            }

            int maxGoleMineAmount = IntStream.range(0, n)
                    .map(index -> dpTable[index][m - 1])
                    .max()
                    .getAsInt();

            System.out.println(maxGoleMineAmount);

        }
    }
}
