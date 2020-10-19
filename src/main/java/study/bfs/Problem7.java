package study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// DFS,BFS 실전문제4. 미로 탈출 (p. 152)
public class Problem7 { // 주의 이 문제는 (1,1) 좌표에 다시 방문할 수도 있기 때문에 문제가 될 수도 있다. 원래라면 방문처리를 해야한다(문제 특성상 상관X, 정 안되면 visited 만들어서 쓰는 것도 괜찮을 듯!)

    private static final int MONSTER = 0;
    private static final int NOT_MONSTER = 1;

    private static int M;
    private static int N;
    private static int[][] maze;
    private static int dx[] = {-1, 1, 0, 0}; // 이동할 방향 {상, 하, 좌, 우}
    private static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 4 <= N <= 200
        M = sc.nextInt(); // 4 <= M <= 200
        sc.nextLine();

        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }

        int answer = bfs(0, 0);
        System.out.println(answer);

    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        // 큐가 빌 때까지 반복하기
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getIndex();
            y = node.getDistance();

            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 괴물이 있는 경우 무시!
                if (maze[nx][ny] == MONSTER) {
                    continue;
                }

                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (maze[nx][ny] == NOT_MONSTER) {
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return maze[N - 1][M - 1];
    }

    static class Node {
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
}
