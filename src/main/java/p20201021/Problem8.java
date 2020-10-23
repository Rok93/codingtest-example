package p20201021;

import java.util.Scanner;

public class Problem8 {
    private static final int EAST = 1;
    private static final int WEST = 2;
    private static final int NORTH = 3;
    private static final int SOUTH = 4;

    // 14499번 주사위 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지도의 세로 크기 ( 1 <= N, M <= 20)
        int M = sc.nextInt();

        int[][] map = new int[N][M];

        int x = sc.nextInt();
        int y = sc.nextInt(); // 주사위를 놓은 곳의 좌표 x,y(0 <= x <= N - 1, 0 <= y <= M - 1)

        int K = sc.nextInt(); // 명령의 개수 (1 <= K <= 1,000)

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {

        }


    }

    public static class Dice {
        private static final int[] UNDER_POINT = {1, 0};
        private static final int[] UPPER_POINT = {1, 2};

        private int[][] status = new int[3][];

        public Dice(int[][] status) {
            status[0] = new int[1];
            status[1] = new int[4];
            status[2] = new int[1];
        }

        public int getUnderSidePoint() {
            return status[UNDER_POINT[0]][UNDER_POINT[1]];
        }

        public int getUpperSidePoint() {
            return status[UPPER_POINT[0]][UPPER_POINT[1]];
        }

        public int rightMove() {
            int temp = status[1][0];
            for (int i = 0; i < 2; i++) {
                status[1][i] = status[1][i + 1];
            }
            status[1][3] = temp;

            return getUnderSidePoint(); // todo: 윗면 보여주는건지 아랫면 보여주는건지 확인!
        }

        public int leftMove() {
            int temp = status[1][0];
            for (int i = 0; i < 2; i++) {
                status[1][i] = status[1][i + 1];
            }
            status[1][3] = temp;

            return getUnderSidePoint(); // todo: 윗면 보여주는건지 아랫면 보여주는건지 확인!
        }


    }
}
