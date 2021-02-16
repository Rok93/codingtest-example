package wootech3rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WooProblem4Test {
    @Test
    void name() {
        //given
        int n1 = 3;
        int n2 = 2;
        int n3 = 4;

        int[][] board1 = {{3, 5, 6}, {9, 2, 7}, {4, 1, 8}};
        int[][] board2 = {{2, 3}, {4, 1}};
        int[][] board3 = {{11, 9, 8, 12}, {2, 15, 4, 14}, {1, 10, 16, 3}, {13, 7, 5, 6}};

        //when
        WooProblem4 sol = new WooProblem4();
        int answer1 = sol.solution(n1, board1);
//        int answer2 = sol.solution(n2, board2);
//        int answer3 = sol.solution(n3, board3);

        //then
        assertThat(answer1).isEqualTo(22);
//        assertThat(answer2).isEqualTo(11);
//        assertThat(answer3).isEqualTo(46);

    }
}
