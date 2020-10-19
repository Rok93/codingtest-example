package study.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// BFS 실전 문제: 경쟁적 전염
public class ActualProblem3 {

    private static int[][] testTube;
    private static int n;
    private static boolean[][] visited;
    private static PriorityQueue<Node> pq;
    private static PriorityQueue<Node> nextPq;

    public static class Node implements Comparable<Node> {
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
        public int compareTo(Node o) {
            if (distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }

    private static int[] dx = {-1, 0, 1, 0};  // 북 동 남 서
    private static int[] dy = {0, 1, 0, -1};
    private static List<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 시험관 크기 (1 <= N <= 200)
        n = sc.nextInt();
        int K = sc.nextInt(); // 바이러스의 종류 (1 <= K <= 1,000)

        testTube = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        pq = new PriorityQueue<>();
        nextPq = new PriorityQueue<>(); // 나는 이거를 썻지만 풀이에서는 그냥 Queue를 썻다. second에 대한 고려이다!
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int inputNumber = sc.nextInt();
                if (inputNumber != 0) {
                    pq.offer(new Node(i, j, inputNumber));
                }
                testTube[i][j] = inputNumber;
            }
        }

        int S = sc.nextInt(); // S초 뒤에  (X, Y)에 존재하는 바이러스 종류를 출력!
        int X = sc.nextInt();
        int Y = sc.nextInt();

        for (int i = 0; i < S; i++) {
            while (!pq.isEmpty()) {
                Node currentNode = pq.poll();
//                System.out.println("현재노드 정보->  크기:" + currentNode.getDistance() + " 위치: " + currentNode.getX() + "," + currentNode.getY());
                int x = currentNode.getX();
                int y = currentNode.getY();

//                if (visited[x][y]) {
//                    continue;
//                }

                visited[x][y] = true;
                virus(currentNode);
            }
            pq = new PriorityQueue<>(nextPq);
            nextPq.clear();
        }

        System.out.println(testTube[X][Y]);
    }

    private static void virus(Node currentNode) {
        for (int i = 0; i < 4; i++) {
            int nx = currentNode.getX() + dx[i];
            int ny = currentNode.getY() + dy[i];

            if (nx < 1 || nx > n || ny < 1 || ny > n || testTube[nx][ny] != 0) {
                continue;
            }

            visited[nx][ny] = true;
            testTube[nx][ny] = currentNode.getDistance();
            nextPq.offer(new Node(nx, ny, currentNode.getDistance()));
        }
    }
}
