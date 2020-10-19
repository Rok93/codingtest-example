package study.dfs;

import java.util.Scanner;

public class ActualProblem6 {
    private static final String TEACHER = "T";
    private static final String STUDENT = "S";
    private static final String OBSTACLE = "O";
    private static final String EMPTY = "X";
    private static final int MAX_OBSTACLE_NUMBER = 3;
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0}; // 동, 남, 서, 북

    private static String[][] map;
    private static String[][] temp;
    private static String answer = "NO";
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // (3 <= N <= 6)
        N = sc.nextInt();

        map = new String[N + 1][N + 1];
        temp = new String[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.next();
            }
        }

        dfs(0);

        System.out.println(answer);

    }

    private static void dfs(int count) {
        if (count == MAX_OBSTACLE_NUMBER) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (temp[i][j].equals(TEACHER)) {
                        if (isInSight(i, j)) { // 시야권이라면!
                            return;
                        }
                    }
                }
            }

            answer = "YES";
            return;
        }

        // 빈 공간에 장애물 세운다!
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].equals(EMPTY)) {
                    map[i][j] = OBSTACLE;
                    dfs(count + 1);
                    map[i][j] = EMPTY;
                }
            }
        }
    }

    private static boolean isInSight(int x, int y) {
        int direction = 0;
        while (direction < 4) {
            int i = x + DX[direction];
            int j = y + DY[direction];

            while (true) {
                if (i < 1 || i > N || j < 1 || j > N) {
                    break;
                }

                if (temp[i][j].equals(OBSTACLE)) {
                    break;
                }

                if (temp[i][j].equals(STUDENT)) {
                    return true;
                }

                i += DX[direction];
                j += DY[direction];
            }

            direction++;
        }

        return false;
    }
}
