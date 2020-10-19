package study.dynamicprogramming;

import java.util.Scanner;

public class Problem2_2 {
    private static int[] dynamicTable = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] foods = new int[N];
        for (int i = 0; i < N; i++) {
            foods[i] = sc.nextInt();
        }

        dynamicTable[0] = foods[0];
        dynamicTable[1] = Math.max(foods[0], foods[1]);
        for (int i = 2; i < N; i++) {
            dynamicTable[i] = Math.max(dynamicTable[i - 1], dynamicTable[i - 2] + foods[i]);
        }
        System.out.println(dynamicTable[N - 1]);
    }
    // A(i) = max(A(i-1), A(i-2) + K(i));  점화식이 성립한다 !
    // ex) 6 / 10 2 3 4 5 6  --> 20
}
