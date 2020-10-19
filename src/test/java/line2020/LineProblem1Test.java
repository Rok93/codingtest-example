package line2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineProblem1Test {
    @DisplayName("라인 1번 문제 테스트 ")
    @Test
    void name() {
        //given
        int[][] boxes1 = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
        int[][] boxes2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] boxes3 = {{1, 2}, {2, 3}, {3, 1}};

        //when
        LineProblem1 sol = new LineProblem1();
        int answer1 = sol.solution(boxes1);
        int answer2 = sol.solution(boxes2);
        int answer3 = sol.solution(boxes3);

        //then
        assertThat(answer1).isEqualTo(2);
        assertThat(answer2).isEqualTo(3);
        assertThat(answer3).isEqualTo(0);
    }
}
