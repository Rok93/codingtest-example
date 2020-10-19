package study.implementation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ActualProblem3_2Test {
    @Test
    void testFunction() {
        //given
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        //when
        ActualProblem3_2 sol = new ActualProblem3_2();
        boolean answer = sol.solution(key, lock);

        //then
        assertThat(answer).isTrue();
    }

}
