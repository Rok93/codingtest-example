package p20201020;

import java.util.Scanner;

public class Problem1 {
    private static final int WALL = 1;
    private static final int BLANK = 0;

    private static final int[] DX = {-1, 0, 1, 0}; // 0:북, 1:동, 2:남, 3:서
    private static final int[] DY = {0, 1, 0, -1};
    private static final int DIRECTION_NUMBER = 4;

    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int M;

    // 14503번 로봇청소기 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int r = sc.nextInt(); // 로봇 x좌표
        int c = sc.nextInt(); // 로봇 y좌표
        int direction = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int value = sc.nextInt();
                map[i][j] = value; // 0: 빈칸, 1: 벽
            }
        }


        dfs(r, c, direction);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

    private static void dfs(int r, int c, int direction) {
//            if (r < 0 || r > N - 1 || c < 0 || c > M - 1) {
//                return;
//            }

        if (!visited[r][c]) {
            visited[r][c] = true;
        }

        for (int i = DIRECTION_NUMBER - 1; i >= 0; i--) {
            int nextDirection = (direction + i) % DIRECTION_NUMBER;
            if (visited[r + DX[nextDirection]][c + DY[nextDirection]] || map[r + DX[nextDirection]][c + DY[nextDirection]] == WALL) {
                continue;
            }

            dfs(r + DX[nextDirection], c + DY[nextDirection], nextDirection);
            return;
        }

        if (map[r - DX[direction]][c - DY[direction]] == WALL) {
            return;
        }

        dfs(r - DX[direction], c - DY[direction], direction);

    }
}
