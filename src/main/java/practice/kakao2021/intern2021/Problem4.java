package practice.kakao2021.intern2021;

public class Problem4 {
    String[] direction = new String[]{"D", "R", "L", "U"}; //방향
    private int len;
    private String curDirection;
    private String beforeDirection;

    public int solution(int[][] board) {
        int answer = 0;
        len = board.length;


        int sum = 100;
        beforeDirection = direction[0]; //down
        curDirection = "";
        dfs(board, 0, 0, sum);

        return answer;
    }

    private void dfs(int[][] board, int x, int y, int sum) {
        if (curDirection.equals(beforeDirection)) {
            sum += 100;
        } else {
            sum += 500;
        }
        beforeDirection = curDirection;

        if (x < 0 || y < 0 || y == len || x == len || board[x][y] == 1) {
            return;
        }

        if (x == len - 1 && y == len - 1) {
            return;
        }

        board[x][y] = 1;

        if (x == 0 && y == 0) {
            curDirection = direction[0];
            for (int i = 0; i < len; i++) {
                board[i] = board[i].clone();
            }
        }

        curDirection = direction[0];
        dfs(board, x + 1, y, sum);

        curDirection = direction[1];
        dfs(board, x, y + 1, sum);

        curDirection = direction[2];
        dfs(board, x, y - 1, sum);

        curDirection = direction[3];
        dfs(board, x - 1, y, sum);
    }
}
