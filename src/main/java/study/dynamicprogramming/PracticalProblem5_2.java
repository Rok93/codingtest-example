package study.dynamicprogramming;

import java.util.Scanner;

public class PracticalProblem5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i2 = 0, i3 = 0, i5 = 0;

        int next2 = 2, next3 = 3, next5 = 5;

        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(next2, Math.min(next3, next5));

            if (ugly[i] == next2) {
                next2 = ugly[++i2] * 2;
//                continue; todo: continue를 당.연.히 넣어야 한다고 생각했는데, 중복되는 경우가 있을 수 있기 때문에 continue는 제외해야한다.
            }

            if (ugly[i] == next3) {
                next3 = ugly[++i3] * 3;
//                continue;
            }

            if (ugly[i] == next5) {
                next5 = ugly[++i5] * 5;
            }
        }

        System.out.println(ugly[n - 1]);
    }
}
