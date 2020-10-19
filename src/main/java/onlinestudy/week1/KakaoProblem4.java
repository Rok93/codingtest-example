package onlinestudy.week1;

// 카카오문제 : 블록 이동하기 (bfs로 접근해야함, DFS 시도했다가 stackoverflow)
public class KakaoProblem4 {
    private int answer;
    private int[][] board;
    private int N;

    public int solution(int[][] board) {
        answer = 0;
        this.board = board;
        N = board.length;

        dfs(0, 0, 0, 1, 0);

        return answer;
    }

    private void dfs(int robotLeftX, int robotLeftY, int robotRightX, int robotRightY, int count) {
        if (robotLeftX >= N || robotLeftY >= N || robotRightX >= N || robotRightY >= N) { // 범위 벗어나면 아웃
            return;
        }

        if (board[robotLeftX][robotLeftY] == 1 || board[robotRightX][robotRightY] == 1) { // 벽이면 아웃
            return;
        }

        if ((robotLeftX == N - 1 && robotLeftY == N) || (robotRightX == N - 1 && robotRightY == N - 1)) {// 목적지 도착이면 기록
            answer = answer > count ? count : answer;
            return;
        }

        // 오른쪽으로 이동
        dfs(robotLeftX, robotLeftY + 1, robotRightX, robotRightY + 1, count + 1);
        // 아래로 이동
        dfs(robotLeftX + 1, robotLeftY, robotRightX + 1, robotRightY, count + 1);
        // 90도 회전 (반시계 방향, 주의: 도는 중에 벽에 걸리면 회전 못함)
        if (robotLeftX == robotRightX) { //현재 로봇이 가로인 경우!
            if (board[robotLeftX + 1][robotLeftY] == 1 || board[robotRightX + 1][robotRightY] == 1) {
                return; // 회전하는데 걸리는게 있다면 회전X
            }

            if (robotLeftY < robotLeftY) { // 이게 돌다보면 왼쪽 오른쪽이 바뀔 수가 있음 (일단 일반적인 경우!)
                // robotLeftY <-- robotRightY랑 같아짐
                // robotLeftX는 + 1 된다.
                dfs(robotLeftX + 1, robotRightY, robotRightX, robotRightY, count + 1);
            } else {
                // robotRightY <-- robotLeftY랑 같아짐
                // robotRightX는 + 1 된다.
                dfs(robotLeftX, robotLeftY, robotRightX + 1, robotLeftY, count + 1);
            }
        }

        if (robotLeftY == robotRightY) { // 현재 로봇이 세로인 경우
            if (board[robotLeftX][robotLeftY + 1] == 1 || board[robotRightX][robotRightY + 1] == 1) {
                return; // 회전하는데 걸리는게 있다면 회전X
            }

            if (robotLeftX > robotRightY) {
                //robotLeftX <-- robotRightX 가 된다.
                // robotLeftY는 + 1 된다.
                dfs(robotLeftY, robotLeftY + 1, robotRightX, robotRightY, count + 1);
            } else {
                //robotRightX <-- robotLeftX 가 된다.
                // robotRightY는 + 1 된다.
                dfs(robotLeftX, robotLeftY, robotLeftX, robotRightY + 1, count + 1);
            }
        }
    }
}
