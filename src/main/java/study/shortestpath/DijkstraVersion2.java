package study.shortestpath;

import java.util.*;

public class DijkstraVersion2 {
    public static class Node implements Comparable<Node> {
        private final int index;
        private final int distance;

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

        @Override
        public String toString() {
            return index + ":" + distance;
        }

        @Override
        public int compareTo(Node o) {
            if (distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }

    private static final int INF = (int) 1e9;

    private static int n, m, start;
    private static List<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] dt = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dt[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (dt[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                Node k = graph.get(now).get(i);
                int cost = dt[now] + k.getDistance();

                if (cost < dt[k.getIndex()]) {
                    dt[k.getIndex()] = cost;
                    pq.offer(new Node(k.getIndex(), k.getDistance()));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(dt, INF);

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            System.out.println(dt[i]);
        }

    }

}
