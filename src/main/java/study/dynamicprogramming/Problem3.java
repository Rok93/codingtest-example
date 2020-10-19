package study.dynamicprogramming;

import java.util.Scanner;

// 다이나믹 프로그래밍: 바닥 공사 (타일링 문제) ... (풀이 3_2 풀이로!!)
public class Problem3 {
    private static int[] dynamicTable = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dynamicTable[1] = 1;
        dynamicTable[2] = 3;
        for (int i = 2; i <= N; i++) {
            dynamicTable[i] = (dynamicTable[i - 1] + 2) % 796796;
        }

        System.out.println(dynamicTable[N]);
    }
}
