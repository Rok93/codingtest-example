package study.shortestpath;

import java.util.*;

public class Problem2 {
    private static final int INF = (int) 1e9;

    private static List<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] d = new int[30001];
    private static int N, M, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 도시의 갯수 N (1 <= N <= 30,000)
        M = sc.nextInt(); // 통로의 개수 M (1 <= M <= 200,000)
        C = sc.nextInt(); // 메시지를 보내고자 하는 도시 C ( 1 <= C <= N)

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();

            graph.get(X).add(new Node(Y, Z));
        }

        Arrays.fill(d, INF);

        dijkstra(C);

        // 출력 하면 됌!
        int sendSuccessNumber = (int) Arrays.stream(d)
                .filter(number -> 0 < number && number < INF)
                .count();

        int maxTime = Arrays.stream(d)
                .filter(number -> number < INF)
                .max()
                .getAsInt();

        System.out.println(sendSuccessNumber + " " + maxTime);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int currentTime = node.getTime();

            // todo: 이 부분을 헷갈림! : 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < currentTime) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                //todo: 이부분도 틀렸음! 현재 Node의 최소시간인 d[now]를 더해야 하는데, 나는 currentTime을 더해버림!
                int cost = d[now] + graph.get(now).get(i).getTime();
                // todo: 이부분도 틀림! : 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        private final int index;
        private final int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Node o) {
            if (time < o.time) {
                return -1;
            }
            return 1;
        }
    }
}
