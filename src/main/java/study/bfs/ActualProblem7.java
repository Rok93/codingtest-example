package study.bfs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

// DFS / BFS 문제 : 인구 이동 (p.353)
public class ActualProblem7 {

    private static int N;
    private static int L;
    private static int R;

    public static class Node {
        private final int x;
        private final int y;
        private final int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y &&
                    distance == node.distance;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, distance);
        }
    }

    private static Queue<Queue<Node>> q = new LinkedList<>();
    private static int[][] land;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 땅의 한 변의 길이 (1 <= N <= 50)
        N = sc.nextInt();
        // (1 <= L <= R <= 100)
        L = sc.nextInt();
        // 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 연다!
        R = sc.nextInt();
        // 국경선이 모두 열리면 인구 이동을 시작한다. 국경선이 열려 있어 인접한 칸만을 이용해 이동, 하루 동안 연합이라 한다.
        // 각 칸의 인구 수 = (연합의 인구 수) / (연합을 이루고 있는 칸의 개수)가 된다. 소수점은 버린다
        // 연합을 해체하고, 모든 국경선을 닫는다.

        land = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        while (true) {
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) { // 방문한 곳은 제외!
                        continue;
                    }

                    Queue<Node> queue = new LinkedList<>();
                    dfs(i, j, 0, queue);
                    if (queue.size() <= 1) {
                        continue;
                    }

                    q.offer(queue);
                }
            }

            if (q.isEmpty()) {
                System.out.println(cnt);
                break;
            }

            //list에 대한 연합국 작업 수행!
            moveToOtherNation();
            cnt++;
        }
    }

    private static void moveToOtherNation() {
        while (!q.isEmpty()) {
            Queue<Node> queue = q.poll();
            int avg = (int) queue.stream()
                    .mapToInt(Node::getDistance)
                    .average()
                    .getAsDouble();

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                land[node.getX()][node.getY()] = avg;
            }
        }
    }

    private static void dfs(int i, int j, int beforeValue, Queue<Node> queue) {
        if (i < 0 || i >= N || j < 0 || j >= N || visited[i][j]) {
            return;
        }

        if (beforeValue != 0 && (L > Math.abs(beforeValue - land[i][j]) || Math.abs(beforeValue - land[i][j]) > R)) {
            return;
        }

        visited[i][j] = true;
        queue.offer(new Node(i, j, land[i][j]));

        dfs(i, j + 1, land[i][j], queue);
        dfs(i, j - 1, land[i][j], queue);
        dfs(i + 1, j, land[i][j], queue);
        dfs(i - 1, j, land[i][j], queue);
    }
}
