package study.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 백준 : 뱀
public class ActualProblem4 {
    private static final int[][] DIRECTION = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서
    public static final int APPLE = 1;
    public static final int EMPTY = 0;
    private static int N;
    private static int[][] boards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        boards = new int[N][N];

        int K = sc.nextInt(); // 사과 개수
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt(); // 사과의 행           (참고 0,0이 아닌 1,1 부터 시작임 )
            int y = sc.nextInt(); // 사과의
            boards[x - 1][y - 1]++;
        }

        int L = sc.nextInt(); // 뱀의 방향 변환 횟수
        Snake snake = new Snake();

        int cnt = 0;
        for (int i = 0; i < L; i++) {
            int X = sc.nextInt();
            for (int j = cnt; j < X; j++) {
                cnt++;
                if (!snake.isMovable()) {
                    System.out.println(cnt);
                    return;
                }

                snake.move();

            }

            String C = sc.next(); // L 은 왼쪽으로 90도, D는 오른쪽으로 90도 회전
            snake.turnDirection(C);
        }


        while (snake.isMovable()) {
            cnt++;
            snake.move();
        }
        cnt++;
        System.out.println(cnt);
    }

    public static class Snake {
        private int[] position = {0, 0};
        private List<int[]> positions = new ArrayList<>();
        private int length = 1;
        private int direction = 1; // 처음 진행 방향

        public void turnDirection(String commend) {
            if (commend.equals("L")) {
                direction--;
                if (direction < 0) {
                    direction = 3;
                }
                return;
            }

            direction++;
            if (direction > 3) {
                direction = 0;
            }
        }

        public void eatApple() {
            boards[position[0]][position[1]]--; //이 위치의 사과 먹는다!
            length++;
        }

        public void move() {
            int[] currentDirection = DIRECTION[direction];
            int nextX = position[0] + currentDirection[0];
            int nextY = position[1] + currentDirection[1];
            if (boards[nextX][nextY] == APPLE) {
                positions.add(position.clone());
                position[0] += currentDirection[0];
                position[1] += currentDirection[1];
                eatApple();
                return;
            }

            positions.add(position.clone());
            positions.remove(0);
            position[0] += currentDirection[0];
            position[1] += currentDirection[1];
        }

        public int[] getPosition() {
            return position;
        }

        public boolean isMovable() {
            int[] currentDirection = DIRECTION[direction];
            int nextX = position[0] + currentDirection[0];
            int nextY = position[1] + currentDirection[1];
            if (nextX >= N || nextX < 0 || nextY >= N || nextY < 0) {
                return false;
            }

            if (length > 1) {
                int[] nextPoint = {nextX, nextY};
                List<int[]> copied = new ArrayList<>(positions);
                for (int[] arr : copied) {
                    if (Arrays.equals(arr, nextPoint))
                        return false;
                }
            }

            return true;
        }
    }
}
