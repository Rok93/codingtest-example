package line2020;

public class LineProblem4 {
    private static final int WALL = 1;
    private int[][] maze;
    private static final int[] DX = {1, 0, -1, 0};  // 왼손법칙 --> 반시계 방향으로 돈다
    private static final int[] DY = {0, 1, 0, -1}; // 남, 동, 북, 서 (방향)

    private static final int[] CHECK_DX = {0, -1, 0, 1}; // 체크해야하는 위치!
    private static final int[] CHECK_DY = {1, 0, -1, 0};

    private int[] cp; // currentPosition
    private int cd; // currentDirection
    private int length;

    public int solution(int[][] maze) {
        this.maze = maze;
        length = maze.length;
        cp = new int[]{0, 0};
        cd = 0;

        int time = 0;
        while (!isReachGoal(cp)) {
            time++;

            if (!checkWall()) { // 벽이 갑자기 없어진 경우 !!
                cd = (cd + 1) % 4;
                go();
                continue;
            }

            while (isNotMove()) { // 진행할 수 없는 경우
                cd = (cd + 3) % 4;
            }

            go();

        }
        return time;
    }

    private void go() {
        cp[0] += DX[cd];
        cp[1] += DY[cd];
    }

    private boolean isNotMove() {
        int nextX = cp[0] + DX[cd];
        int nextY = cp[1] + DY[cd];

        int length = maze.length;
        if (nextX < 0 || nextX >= length || nextY < 0 || nextY >= length) { // 범위 넘어서면 false
            return true;
        }

        if (maze[nextX][nextY] == WALL) { // 방문 했던 곳이거나 다음 위치가 벽이라면
            return true;
        }

        return false;
    }

    private boolean checkWall() {
        int checkX = cp[0] + CHECK_DX[cd];
        int checkY = cp[1] + CHECK_DY[cd];

        if (checkX == length || checkX == -1 || checkY == length || checkY == -1 || maze[checkX][checkY] == WALL) { // 벽 체크!
            return true;
        }

        return false;
    }

    private boolean isReachGoal(int[] position) {
        int length = maze.length;
        return (position[0] == length - 1) && (position[1] == length - 1);
    }
}
