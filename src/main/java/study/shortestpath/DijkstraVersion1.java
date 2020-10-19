package study.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DijkstraVersion1 {
    public static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }

    private static final int INF = (int) 1e9; // 무한대! 라는 의미로 10억 설정함

    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    private static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    private static List<ArrayList<Node>> graph = new ArrayList<>();
    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
    private static boolean[] visited = new boolean[100001];
    // 최단 거리 테이블 만들기
    private static int[] dt = new int[100001];

    // 방문하지 않는 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int minValue = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스), 0은 없는 값이니까 설정하는 것!
        for (int i = 1; i <= n; i++) {
            if (dt[i] < minValue && !visited[i]) {
                minValue = dt[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        dt[start] = 0; // 이부분 필요 없다고 생각
        visited[start] = true;
        int startNodeSize = graph.get(start).size();
        for (int i = 0; i < startNodeSize; i++) {
            dt[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;

            // 현재 노드와 연결된 다른 노드를 확인
            int noeConnectedNodeSize = graph.get(now).size();
            for (int j = 0; j < noeConnectedNodeSize; j++) {
                int cost = dt[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < dt[graph.get(now).get(j).getIndex()]) {
                    dt[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미이다.
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블은 모두 무한으로 초기화!
        Arrays.fill(dt, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            if (dt[i] == INF) {
                System.out.println("INFINITY");
                continue;
            }

            System.out.println(dt[i]);
        }
    }
}

/*
입력 예시
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

출력 예시
0
2
3
1
2
4
 */
