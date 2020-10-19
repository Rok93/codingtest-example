package onlinestudy.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem4Test {
    @Test
    void testFunction() {
        //given
        int[][] boards = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};

        //when
        KakaoProblem4 sol = new KakaoProblem4();
        int answer = sol.solution(boards);

        //then
        assertThat(answer).isEqualTo(7);
    }
}
