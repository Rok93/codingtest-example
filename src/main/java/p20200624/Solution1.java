package p20200624;

import java.util.Scanner;

public class Solution1 {
    private static final int[] ARR = {1, 2, 3};
    private static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNumber = sc.nextInt();
        for (int i = 0; i < tryNumber; i++) {
            cnt = 0;
            dfs(sc.nextInt(), 0);
            System.out.println(cnt);
        }
    }

    private static void dfs(int targetNumber, int answer) {
        if (answer == targetNumber) {
            cnt++;
            return;
        }

        if (answer > targetNumber) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(targetNumber, answer + ARR[i]);
        }
    }
}
