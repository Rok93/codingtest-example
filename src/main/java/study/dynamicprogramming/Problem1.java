package study.dynamicprogramming;

import java.util.Scanner;

// 다이나믹 프로그래밍: 1로 만들기 p. 217
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int cnt = 0;
        while (X != 1) {
            cnt++;
            X = calculate(X);
        }
        System.out.println(cnt);
    }

    private static int calculate(int x) {
        if (x % 5 == 1) {
            x -= 1;
            return x;
        }

        if (x % 5 == 0) {
            x /= 5;
            return x;
        }

        if (x % 3 == 1) {
            x -= 1;
            return x;
        }

        if (x % 3 == 0) {
            x /= 3;
            return x;
        }

        if (x % 2 == 0) {
            x /= 2;
            return x;
        }

        x -= 1;
        return x;
    }
}
