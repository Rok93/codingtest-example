package study.implementation;

import java.util.Scanner;

// 왕실의 나이트
public class Problem3 {
    private static final int[][] MOVE_DIRECTION = {{2, -1}, {2, 1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public static void main(String[] args) {
        //나이트의 이동 방향은 (수평으로 두칸, 수직 한칸) or (수직 2칸, 수평 한칸)
        Scanner sc = new Scanner(System.in);
        char[] inputPosition = sc.nextLine().toCharArray();
        int nightX = inputPosition[0] - 'a';
        int nightY = inputPosition[1] - '1';

        int answer = 0;
        for (int[] direction : MOVE_DIRECTION) {
            int nextX = nightX + direction[0];
            if (0 > nextX || nextX >= 8) {
                continue;
            }

            int nextY = nightY + direction[1];
            if (0 > nextY || nextY >= 8) {
                continue;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
