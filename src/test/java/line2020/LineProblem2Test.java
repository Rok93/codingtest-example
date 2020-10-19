package line2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineProblem2Test {
    @DisplayName("라인 2번 문제 풀이 ")
    @Test
    void name() {
        //given
        int[] ball1 = {1, 2, 3, 4, 5, 6};
        int[] order1 = {6, 2, 5, 1, 4, 3};

        int[] ball2 = {11, 2, 9, 13, 24};
        int[] order2 = {9, 2, 13, 24, 11};

        //when
        LineProblem2 sol = new LineProblem2();
        int[] answer1 = sol.solution(ball1, order1);
        int[] answer2 = sol.solution(ball2, order2);

        //then
        assertThat(answer1).isEqualTo(new int[]{6, 5, 1, 2, 4, 3});
        assertThat(answer2).isEqualTo(new int[]{24, 13, 9, 2, 11});
    }
}
