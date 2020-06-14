package p20200606;

public class Study2 {
    public static final int BLACK = 1;
    public static final int WHITE = 2;
    private int[][] board;

    public int solution(int[][] board) { //1: 검은돌, 2: 흰돌
        int answer = 0;
        this.board = board;
        int len = board.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 1) { //검은돌 찾기
                    if (isWin(i, j, BLACK)) {
                        return BLACK;
                    }
                    continue;
                }

                if (board[i][j] == 2) { //흰돌 찾
                    if (isWin(i, j, WHITE)) {
                        return WHITE;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isWin(int x, int y, int rockNumber) { // 1
        int len = board.length;
        int cnt = 0;
        if (x + 5 <= len - 1) {
            for (int i = x; i < x + 5; i++) {
                if (board[i][y] != rockNumber) {
                    break;
                }
                cnt++;
            }
            if (cnt == 5) {
                return true;
            }
            cnt = 0;
        }

        if (x >= 5) {
            for (int i = x; i >= 0; i--) {
                if (board[i][y] != rockNumber) {
                    break;
                }
                cnt++;
            }
            if (cnt == 5) {
                return true;
            }
            cnt = 0;
        }

        if (y + 5 <= len - 1) {
            for (int i = y; i < y + 5; i++) {
                if (board[x][i] != rockNumber) {
                    break;
                }
                cnt++;
            }
            if (cnt == 5) {
                return true;
            }
            cnt = 0;
        }

        if (y >= 5) {
            for (int i = y; i >= 0; i--) {
                if (board[x][i] != rockNumber) {
                    break;
                }
                cnt++;
            }
            if (cnt == 5) {
                return true;
            }
        }
        return false;
    }
}
