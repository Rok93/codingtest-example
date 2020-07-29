package practice.kakao2021.intern;

import java.util.ArrayList;
import java.util.List;

/**
 * stack을 5개 만들고(LIFO), 쌓이는 곳도 stack으로 총 6개의 스택을 이용한 방법도 있다! (맨 윗부분을 잡아야한다는 전제를 생각했을 때 유용함!!)
 */
class Problem1 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    list.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    if (list.size() > 1) {
                        if (list.get(list.size() - 1).equals(list.get(list.size() - 2))) {
                            answer += 2;
                            list.remove(list.size() - 1);
                            list.remove(list.size() - 1);
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}