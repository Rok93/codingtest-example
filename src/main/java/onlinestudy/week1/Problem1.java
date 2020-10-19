package onlinestudy.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 구슬 탈출 2 : https://www.acmicpc.net/problem/13460 개어렵 ...ㄷㄷ ....
public class Problem1 {
    private static final char EMPTY_SPACE = '.';
    private static final char OBSTACLE = '#'; // 공이 이동할 수 없는 장애물 or 벽
    private static final char HOLE = 'O';
    private static final char RED_MARBLE = 'R';
    private static final char BLUE_MARBLE = 'B';
    public static final int X = 0;
    public static final int Y = 1;
    private static char[][] board;
    private static List<Integer> results;
    private static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동, 서, 남, 북

    public static void main(String[] args) { // 1,1 부터 N - 2, M - 2 까지 서칭 !
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = sc.next()
                    .toCharArray();
        }

        int[] redPoint = new int[2];
        int[] bluePoint = new int[2];
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (board[i][j] == RED_MARBLE) {
                    redPoint[X] = i;
                    redPoint[Y] = j;
                    continue;
                }

                if (board[i][j] == BLUE_MARBLE) {
                    bluePoint[X] = i;
                    bluePoint[Y] = j;
                }
            }
        }

        results = new ArrayList<>();

        for (int[] direction : DIRECTIONS) {
            dfs(redPoint.clone(), bluePoint.clone(), direction, 0);
        }

        int answer = results.stream()
                .mapToInt(Integer::new)
                .min()
                .getAsInt();
        System.out.println(answer);
    }

    private static void dfs(int[] redPoint, int[] bluePoint, int[] currentDirection, int tryNumber) {
        if (tryNumber > 10) {
            return;
        }

        boolean redPass = false;
        boolean bluePass = false;
        while (isMovable(redPoint, currentDirection)
                || isMovable(bluePoint, currentDirection)) {
            System.out.println(Arrays.toString(redPoint));
            System.out.println(Arrays.toString(bluePoint));

            if (isMovable(redPoint, currentDirection) && !redPass) {
                int[] nextRedPoint = getNextPoint(redPoint, currentDirection, RED_MARBLE);

                if (extractBoard(nextRedPoint) == HOLE) {
                } else if (extractBoard(nextRedPoint) == EMPTY_SPACE) {
                    swap(redPoint, nextRedPoint);
                }
            }

            if (isMovable(bluePoint, currentDirection)) {
                int[] nextBluePoint = getNextPoint(bluePoint, currentDirection, BLUE_MARBLE);

                if (extractBoard(nextBluePoint) == HOLE) {
                    bluePass = true;
                } else if (extractBoard(nextBluePoint) == EMPTY_SPACE) {
                    swap(bluePoint, nextBluePoint);
                }
            }
        }

        if (redPass) {
            if (!bluePass) {
                results.add(tryNumber);
                return;
            }

            return;
        }

        for (int[] direction : DIRECTIONS) {
            dfs(redPoint, bluePoint, direction, tryNumber + 1);
        }
    }

    private static void swap(int[] redPass, int[] nextRedPoint) {
        int[] temp = redPass.clone();
        redPass = nextRedPoint.clone();
        nextRedPoint = temp;
    }

    private static char extractBoard(int[] point) {
        return board[point[X]][point[Y]];
    }

    private static boolean isPassHole(int[] point) {
        return board[point[X]][point[Y]] == HOLE;
    }

    private static int[] getNextPoint(int[] point, int[] currentDirection, char c) {
        int pointX = point[X];
        int pointY = point[Y];
        board[pointX][pointY] = EMPTY_SPACE;
        return new int[]{pointX + currentDirection[X], pointY + currentDirection[Y]};
    }

    private static boolean isMovable(int[] point, int[] direction) {
        int nextX = point[X] + direction[X];
        int nextY = point[Y] + direction[Y];
        char movedValue = board[nextX][nextY];

        if (movedValue == EMPTY_SPACE || movedValue == HOLE) { // 공백 or 구멍
            return true;
        }

        return false; // 장애물 or redMarble or blueMarble
    }
}
