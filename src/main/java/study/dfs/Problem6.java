package study.dfs;

import java.util.Arrays;
import java.util.Scanner;

// 실전 문제3. 음료수 얼려 먹기 (p. 149)
public class Problem6 {
    private static final int EMPTY = 0;
    private static final int FULL = 1;

    private static boolean[][] visited;
    private static int[][] trays;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        trays = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            trays[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || trays[i][j] == FULL) {
                    continue;
                }
                dfs(i, j);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) { // ArrayIndexOutOfBoundsException을 방지해 줌!
            return;
        }

        if (visited[i][j] || trays[i][j] == FULL) {
            return;
        }

        visited[i][j] = true;

        dfs(i - 1, j); // 가급적 여기서 조건 거르지 말고, 일단 넘겨주고 위에서 걸러주는 방식으로
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}

