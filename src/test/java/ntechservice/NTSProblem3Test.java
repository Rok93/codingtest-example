package ntechservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NTSProblem3Test {
    @DisplayName("엔테크 3번문제 풀이 ")
    @Test
    void name() {
        //given
        int[] histogram1 = {2, 2, 2, 3};
        int[] histogram2 = {6, 5, 7, 3, 4, 2};

        //when
        NTSProblem3 sol = new NTSProblem3();
        int answer1 = sol.solution(histogram1);
        int answer2 = sol.solution(histogram2);

        //then
        assertThat(answer1).isEqualTo(4);
        assertThat(answer2).isEqualTo(12);
    }
}
