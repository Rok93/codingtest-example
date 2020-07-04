package p20200624;

import java.util.Scanner;

public class Solution2 {
    private static int answer = 0;
    private static int N;
    private static int[] T;
    private static int[] P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //퇴사일
        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int day, int money) {
        if (day >= N) {
            answer = Math.max(answer, money);
            return;
        }

        if (day + T[day] <= N) {
            dfs(day + T[day], money + P[day]);
        }
        dfs(day + 1, money);
    }
}
