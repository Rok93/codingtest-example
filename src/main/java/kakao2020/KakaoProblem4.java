package kakao2020;

import java.util.Arrays;

public class KakaoProblem4 {
    private int[][] graph = new int[201][201];
    private static final int INF = 100000 * 200;

    public int solution(int n, int s, int a, int b, int[][] fares) { // 플로이드 워셜 삘임

        // n: 지점 갯수 ( 3 <= n <= 200)
        // s : 출발지점, a : A의 도착지점, b: B의 도착지점  (s, a, b 는 1 ~ n 사이의 겹치지 않는 값 )

        for (int i = 0; i < 201; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];
            graph[start][end] = cost;
            graph[end][start] = cost;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) { // 노드의 개수
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int eachGo = graph[s][a] + graph[s][b];
        System.out.println("eachGo: " + eachGo);
        int min = INF;
        for (int k = 1; k <= n; k++) {
            int sum = 0;
            if (a != b) {
                sum = graph[s][k] + graph[k][a] + graph[k][b];
            } else {
                sum = graph[s][a];
            }
            min = Math.min(min, sum);
        }
        System.out.println("min: " + min);
        System.out.println();

        return eachGo < min ? eachGo : min;
    }
}
