package ntechservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NTSProblem1Test {
    @DisplayName("엔테크 1번문제 풀이!")
    @Test
    void name() {
        //given
        int[][] flowers1 = {{2, 5}, {3, 7}, {10, 11}};
        int[][] flowers2 = {{3, 4}, {4, 5}, {6, 7}, {8, 10}};

        //when
        NTSProblem1 sol = new NTSProblem1();
        int answer1 = sol.solution(flowers1);
        int answer2 = sol.solution(flowers2);

        //then
        assertThat(answer1).isEqualTo(6);
        assertThat(answer2).isEqualTo(5);
    }
}
