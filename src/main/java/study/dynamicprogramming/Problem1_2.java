package study.dynamicprogramming;

import java.util.Scanner;

public class Problem1_2 {
    private static int[] dpTable = new int[300001]; // dp table... (X의 범위가 100만 보다 작음 할만함)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(); // 1 <= X <= 30,000

        for (int i = 2; i <= X; i++) { // dpTable[1] = 0 이다.  이미 1이니까!
            dpTable[i] = dpTable[i - 1] + 1;

            if (i % 2 == 0) {
                dpTable[i] = Math.min(dpTable[i], dpTable[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dpTable[i] = Math.min(dpTable[i], dpTable[i / 3] + 1);
            }

            if (i % 5 == 0) {
                dpTable[i] = Math.min(dpTable[i], dpTable[i / 5] + 1);
            }
        }

        System.out.println(dpTable[X]);
    }
}
