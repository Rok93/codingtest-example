package study.shortestpath;

import java.util.Arrays;
import java.util.Scanner;

// p.259 : 미래 도시
public class Problem1 {
    private static final int INF = (int) 1e9;

    private static int n, m, x, k;
    private static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 전체 회사의 개수 ( 1 <= N <= 100)
        m = sc.nextInt(); // 경로의 개수 (1 <= M <= 100)

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= m; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 양방향 !
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt(); // 목표 지점
        k = sc.nextInt(); // 1 <= k <= 100

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int shortestDistance = graph[1][k] + graph[k][x];
        if (shortestDistance >= INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(shortestDistance);
    }
}
/*
이 문제는 전형적인 '플로이드 워셜' 알고리즘 문제이다.
N의 범위가 100 이하로 매우 한정적이다.
 */
