package study.bfs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// DFS, BFS 실전문제 : 특정 거리의 도시찾기 (p. 339)
public class ActualProblem1 {

    private static final int INF = (int) 1e9;
    private static List<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] dt = new int[300001];
    private static boolean[] visited = new boolean[300001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 도시의 개수 (2 <= N <= 300,000)
        int M = sc.nextInt(); // 도로의 개수 (1 <= M <= 1,000,000)
        int K = sc.nextInt(); // 거리 정보 (1 <= K <= 300,000)
        int X = sc.nextInt(); // 특정한 도시 (1 <= X <= N)

        Arrays.fill(dt, INF);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        dijkstra(X);

        String answer = IntStream.rangeClosed(1, N)
                .filter(index -> dt[index] == K)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n"));

        if (answer.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);

    }

    private static void dijkstra(int start) {
        Queue<Integer> pq = new LinkedList<>();
        pq.add(start);
        dt[start] = 0;

        while (!pq.isEmpty()) {
            int now = pq.poll();

            int size = graph.get(now).size();
            for (int i = 0; i < size; i++) {
                int nextNode = graph.get(now).get(i);

                if (dt[nextNode] == INF) {
                    dt[nextNode] = dt[now] + 1;
                    pq.offer(nextNode);
                }
            }
        }
    }
}
