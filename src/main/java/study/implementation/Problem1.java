package study.implementation;

import java.util.Scanner;

public class Problem1 {
    private static final String MOVE_RIGHT = "R";
    private static final String MOVE_LEFT = "L";
    private static final String MOVE_UP = "U";
    private static final String MOVE_DOWN = "D";
    private static final int[] START_POINT = {1, 1};
    private static final int COLUMN = 1;
    private static final int ROW = 0;

    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기! (꿀팁)
        String[] plans = sc.nextLine().split(" ");

        int[] currentPoint = START_POINT;

        for (String plan : plans) {
            move(currentPoint, plan);
        }

        System.out.println(currentPoint[0] + " " + currentPoint[1]);
    }

    private static void move(int[] currentPoint, String plan) {
        if (plan.equals(MOVE_RIGHT)) {
            if (currentPoint[COLUMN] + 1 <= n) {
                currentPoint[COLUMN]++;
                return;
            }

            return;
        }

        if (plan.equals(MOVE_LEFT)) {
            if (currentPoint[COLUMN] - 1 > 0) {
                currentPoint[COLUMN]--;
                return;
            }

            return;
        }

        if (plan.equals(MOVE_UP)) {
            if (currentPoint[ROW] - 1 > 0) {
                currentPoint[ROW]--;
                return;
            }

            return;
        }

        if (plan.equals(MOVE_DOWN)) {
            if (currentPoint[ROW] + 1 <= n) {
                currentPoint[ROW]++;
                return;
            }
            return;
        }
    }
}
