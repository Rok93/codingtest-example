package basicAlgorithm;

import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {
    private int[][] adj = new int[1001][];

    private void bfs(int start) {
        boolean[] visited = new boolean[1001];
        Queue<Integer> queue = new PriorityQueue<>();

        queue.offer(start); // 시작점을 큐에 저장
        visited[start] = true; // 시작점을 방문했다고 표시

        while (!queue.isEmpty()) {
            int cur = queue.poll(); //큐에 저장된 값중 가장 먼저 저장된 정점을 선택

            for (int i = 0; i < adj[cur].length; i++) { //해당 정점과 연결된 모든 정점 확인
                int next = adj[cur][i];
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
