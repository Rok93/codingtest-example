package study.graphtheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// p.300 : 도시 분할 계획
public class Problem2 {
    public static class Edge implements Comparable<Edge> {
        private final int distance;
        private final int nodeA;
        private final int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getDistance() {
            return distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }


        @Override
        public int compareTo(Edge o) {
            if (distance - o.distance < 0) {
                return -1;
            }

            return 1;
        }
    }

    private static int[] parent = new int[100001]; // 부모 테이블 초기화
    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    private static List<Edge> edges = new ArrayList<>();
    private static int result = 0;

    private static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
            return;
        }

        parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 집의 개수 ( 2 <= N <= 100,000)
        int M = sc.nextInt(); // 길의 개수 ( 1 <= M <= 1,000,000)

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) { // A번집과 B번 집을 연결하는 길의 유지비가 C
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            edges.add(new Edge(cost, a, b));
        }

        Collections.sort(edges);
        int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선

        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함!
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result - last);


    }
}
