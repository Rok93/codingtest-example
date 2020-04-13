package practice;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    list.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    if (isDuplicated(list)) {
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }

    private boolean isDuplicated(List<Integer> list) {
        if (list.size() > 1) {
            if (list.get(list.size() - 1).equals(list.get(list.size() - 2))) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Problem1 sol = new Problem1();

        System.out.println(sol.solution(board, moves));

    }
}
