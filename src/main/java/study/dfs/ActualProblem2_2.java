package study.dfs;

import java.util.Scanner;

public class ActualProblem2_2 {
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1}; // 북동남서
    private static final int MAX_CONSTRUCTOR_WALL_NUMBER = 3;

    private static int[][] map;
    private static int[][] temp;
    private static int N;
    private static int M;

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0); // VIRUS인 경우에만 실행!
        System.out.println(answer);
    }

    private static void dfs(int count) {
        if (count == MAX_CONSTRUCTOR_WALL_NUMBER) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == VIRUS) {
                        spreadVirus(i, j);
                    }
                }
            }

            answer = Math.max(answer, count(temp));
            return;
        }

        // 빈 공간에 울타리를 설치한다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = WALL;
                    dfs(count + 1);
                    map[i][j] = EMPTY;
                }
            }
        }
    }

    private static void spreadVirus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (temp[nx][ny] == EMPTY) {
                temp[nx][ny] = VIRUS;
                spreadVirus(nx, ny);
            }
        }
    }

    private static int count(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == EMPTY) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
