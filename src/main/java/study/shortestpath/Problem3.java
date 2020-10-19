package study.shortestpath;

import java.util.*;

// p. 300 : 도시 분할 계획 --> 위상 정렬
public class Problem3 {

    private static int[] indegree = new int[501]; // 진입차수
    private static int[] times = new int[501];

    private static List<ArrayList<Integer>> graph = new ArrayList<>();
    private static int n;

    // 위상 정렬
    private static void topologySort() {
        int[] result = new int[501];
        for (int i = 1; i <= n; i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>();

        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
//                break;
            }
        }

        while (!q.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = q.poll();
            // 해당 원소와 연결된 노드들의 진입차수에서 1빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)]--;

                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        // 위상 정렬을 수행한 결과
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 강의의 수 (1 <= N <= 500)
        n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt(); // 첫 번째 수는 시간 정보를 담고 있음
            times[i] = x;

            // 해당 강의를 듣기 위해 먼저 들어야 하는 강의들의 번호 입력
            while (true) {
                x = sc.nextInt();
                if (x == -1) {
                    break;
                }

                indegree[i]++;
                graph.get(x).add(i);
            }
        }

        topologySort();

    }
}
