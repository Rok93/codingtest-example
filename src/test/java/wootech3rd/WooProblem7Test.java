package wootech3rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WooProblem7Test {
    @Test
    void name() {
        //given
        int n1 = 4;
        int n2 = 5;

        boolean horizontal1 = true;
        boolean horizontal2 = false;

        //when
        WooProblem7 sol = new WooProblem7();
        int[][] answer1 = sol.solution(n1, horizontal1);
        int[][] answer2 = sol.solution(n2, horizontal2);

        //then
        assertThat(answer1).isEqualTo(new int[][]{{0, 1, 8, 9}, {3, 6, 11, 20}, {4, 13, 18, 21}, {15, 16, 23, 24}});
        assertThat(answer2).isEqualTo(new int[][]{{0, 3, 4, 15, 16}, {1, 6, 13, 18, 31}, {8, 11, 20, 29, 32}, {9, 22, 27, 34, 39}, {24, 25, 36, 37, 40}});
    }
}
