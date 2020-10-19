package study.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    private static final int X = 0;
    private static final int Y = 1;
    private static final int LAND = 0;
    private static final int OCEAN = 1;
    private static final int NORTH = 0;
    private static final int WEST = 3;
    private static final int[][] DIRECTION = {{-Y, X}, {X, Y}, {Y, X}, {X, -Y}}; // 북, 동, 남, 서
    private static int mapHeight;
    private static int mapWidth;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mapHeight = sc.nextInt();
        mapWidth = sc.nextInt();
        int A = sc.nextInt(); // 북쪽으로부터 떨어진 칸의 개수 (초기 x 좌표)
        int B = sc.nextInt(); // 서쪽으로부터 떨어진 칸의 개수 (초기 y 좌표)
        int direction = sc.nextInt();
        int[] currentPosition = {A, B};

        visited = new boolean[mapHeight][mapWidth];
        map = new int[mapHeight][mapWidth];
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited[A][B] = true;
        int answer = Y;
        while (true) {
            System.out.println(Arrays.toString(currentPosition));
            int currentDirection = direction;
            boolean isMove = false;
            for (int i = 0; i < 4; i++) {
                currentDirection = turnLeft(currentDirection);

                if (isMovable(currentPosition, currentDirection)) {
                    direction = currentDirection;
                    move(currentPosition, currentDirection);
                    answer++;
                    isMove = true;
                    visited[currentPosition[X]][currentPosition[Y]] = true;
                    break;
                }
            }

            if (!isMove) { // 이동하지 못했다면
                // 움직이지 못했을 때! (방향은 이미 원상태 복구)
                if (isMoveBack(currentPosition, direction)) { // 뒤로 한 걸음 물러 설 수 있으면
                    moveBack(currentPosition, direction); // 한 걸음 뒤로 물러선다!
                    continue;
                }
                break;
            }
        }
        System.out.println(answer);
    }

    private static int turnLeft(int currentDirection) {
        currentDirection--;
        if (currentDirection < NORTH) {
            currentDirection = WEST;
        }
        return currentDirection;
    }

    private static void moveBack(int[] currentPosition, int direction) {
        int[] currentDirection = DIRECTION[direction];
        currentPosition[X] -= currentDirection[X];
        currentPosition[Y] -= -currentDirection[Y];
    }

    private static boolean isMoveBack(int[] currentPosition, int direction) {
        int[] currentDirection = DIRECTION[direction];
        int nextX = currentPosition[X] - currentDirection[X];
        int nextY = currentPosition[Y] - currentDirection[Y];
        if ((nextX < X || nextX >= mapHeight) || (nextY < X || nextY >= mapWidth)) {
            return false;
        }

        if (map[nextX][nextY] == LAND) { // 육지
            return true;
        }

        return false;
    }

    private static void move(int[] currentPosition, int nextDirection) {
        int[] direction = DIRECTION[nextDirection];
        currentPosition[X] += direction[X];
        currentPosition[Y] += direction[Y];
    }

    private static boolean isMovable(int[] currentPosition, int currentDirection) {
        int[] direction = DIRECTION[currentDirection];
        int nextX = currentPosition[X] + direction[X];
        int nextY = currentPosition[Y] + direction[Y];
        if ((nextX < X || nextX >= mapHeight) || (nextY < X || nextY >= mapWidth)) {
            return false;
        }

        if (map[nextX][nextY] == LAND && !visited[nextX][nextY]) { // 육지 and 방문X
            return true;
        }

        return false;
    }
}
