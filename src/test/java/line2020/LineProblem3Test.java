package line2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineProblem3Test {
    @DisplayName("라인 3번 문제 풀이 ")
    @Test
    void name() {
        //given
        int n1 = 73425;
        int n2 = 10007;
        int n3 = 9;

        //when
        LineProblem3 sol = new LineProblem3();
        int[] answer1 = sol.solution(n1);
        int[] answer2 = sol.solution(n2);
        int[] answer3 = sol.solution(n3);

        //then
        assertThat(answer1).isEqualTo(new int[]{4, 3});
        assertThat(answer2).isEqualTo(new int[]{4, 8});
        assertThat(answer3).isEqualTo(new int[]{0, 9});
    }
}
