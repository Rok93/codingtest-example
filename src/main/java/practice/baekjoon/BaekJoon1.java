package practice.baekjoon;

import java.util.Scanner;

public class BaekJoon1 {
    static final int inf = -100000000;
    static int[] t;
    static int[] p;
    static int n;

    static int go(int day, int sum) {
        if (day == n + 1) {
            // 방법 1개
            return sum;
        }
        if (day > n + 1) { // 불가능한 경우
            return 0;
        }
        int t1 = go(day + 1, sum);
        int t2 = go(day + t[day], sum + p[day]);
        return Math.max(t1, t2);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        int ans = go(1, 0);
        System.out.println(ans);
    }
}
/*
백준 - 14501번 문제
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200   --> 45
 */
