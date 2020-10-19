package ntechservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NTSProblem2Test {
    @DisplayName("엔테크 2번문제 풀이!")
    @Test
    void name() {
        //given
        int N1 = 1;
        int N2 = 2;
        int N3 = 3;

        //when
        NTSProblem2 sol = new NTSProblem2();
        int answer1 = sol.solution(N1);
        int answer2 = sol.solution(N2);
        int answer3 = sol.solution(N3);

        //then
        assertThat(answer1).isEqualTo(1);
        assertThat(answer2).isEqualTo(2);
        assertThat(answer3).isEqualTo(3);
    }
}
