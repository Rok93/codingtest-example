package study.dfs;

import java.util.Scanner;

// DFS/BFS 문제 : 연구소 (p. 341)
public class ActualProblem2 {
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1}; // 북동남서
    private static final int MAX_CONSTRUCTOR_WALL_NUMBER = 3;

    private static boolean[][] visited;
    private static int[][] map;
    private static int N;
    private static int M;

    private static int answer = 0;
    private static boolean[][] copiedVisited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int status = map[i][j];
                if (status != VIRUS) {
                    continue;
                }

                dfs(i, j, 0); // VIRUS인 경우에만 실행!
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int i, int j, int count) {

        if (i < 0 || i >= N || j < 0 || j >= M || visited[i][j]) {
            return;
        }

        if (count >= MAX_CONSTRUCTOR_WALL_NUMBER) {
            int[][] copiedMap = copyTwoLevelArr(map);
            spreadVirus(copiedMap);
            answer = Math.max(answer, count(map));
            return;
        }

        int currentStatus = map[i][j];
        if (currentStatus == WALL) {
            return;
        }

        if (currentStatus == EMPTY) {
            visited[i][j] = true;
            map[i][j] = WALL;
            for (int k = 0; k < 4; k++) {
                dfs(i + DX[k], j + DY[k], count + 1);
            }

            map[i][j] = EMPTY;
            for (int k = 0; k < 4; k++) {
                dfs(i + DX[k], j + DY[k], count);
            }
            return;
        }

        // virus인 경우!
        for (int k = 0; k < 4; k++) {
            dfs(i + DX[k], j + DY[k], count);
        }
    }

    private static void spreadVirus(int[][] copiedMap) {
        copiedVisited = new boolean[copiedMap.length][copiedMap[0].length];
        for (int i = 0; i < copiedMap.length; i++) {
            for (int j = 0; j < copiedMap[0].length; j++) {
                if (copiedMap[i][j] == VIRUS) {
                    spread(copiedMap, i, j);
                }
            }
        }
    }

    private static void spread(int[][] copiedMap, int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= M || copiedMap[i][j] == WALL || copiedVisited[i][j]) {
            return;
        }

        if (copiedMap[i][j] == EMPTY) {
            copiedVisited[i][j] = true;
            copiedMap[i][j] = VIRUS;
        }

        for (int k = 0; k < 4; k++) {
            spread(copiedMap, i + DX[k], j + DY[k]);
        }
    }

    private static int[][] copyTwoLevelArr(int[][] arr) {
        int length = arr.length;
        int[][] newArr = new int[length][arr[0].length];
        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i].clone();
        }

        return newArr;
    }

    private static int count(int[][] map) {
        int cnt = 0;
        for (int[] line : map) {
            for (int block : line) {
                if (block == EMPTY) {
                    cnt++;
                }
            }
        }

        return cnt;
    }


}
