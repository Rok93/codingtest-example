package p20200823.socar;

public class SocarProblem2 {
    private static final char GO_DOWN = '#';
    private static final char GO_RIGHT = '>';
    private static final char GO_LEFT = '<';
    private static final char STOP = '*';

    private boolean isFirstSTOP = true;

    public int solution(String[] drum) {
        int boardHeight = drum.length;
        int boardWidth = drum[0].length();
        char[][] board = new char[boardHeight][boardWidth];

        for (int i = 0; i < boardHeight; i++) {
            board[i] = drum[i].toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < boardWidth; i++) {
            isFirstSTOP = true;
            if (isFallMarble(board, i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isFallMarble(char[][] board, int row) {
        return play(board, row, 0);
    }

    private boolean play(char[][] board, int row, int depth) {
        if (depth >= board.length) {
            return true;
        }

        if (row < 0 || row >= board[0].length) {
            return false;
        }

        char currentChar = board[depth][row];

        if (currentChar == GO_DOWN) {
            return play(board, row, depth + 1);
        }

        if (currentChar == GO_LEFT) {
            return play(board, row - 1, depth);
        }

        if (currentChar == GO_RIGHT) {
            return play(board, row + 1, depth);
        }

        //STOP 조건
        if (isFirstSTOP) {
            isFirstSTOP = false;
            return play(board, row, depth + 1);
        }

        return false;
    }
}
