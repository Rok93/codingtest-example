package naver2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NaverProblem2Test {
    @DisplayName("네이버 2번문제!")
    @Test
    void name() {
        //given
        int[][] blocks1 = {{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}};
        int[][] blocks2 = {{0, 92}, {1, 20}, {2, 11}, {1, -81}, {3, 98}};

        //when
        NaverProblem2 sol = new NaverProblem2();
        int[] answer1 = sol.solution(blocks1);
        int[] answer2 = sol.solution(blocks2);

        //then
        assertThat(answer1).isEqualTo(new int[]{50, 22, 28, 4, 18, 10, 0, 4, 14, -4, 1, -1, 5, 9, -13});
        assertThat(answer2).isEqualTo(new int[]{92, 72, 20, 63, 9, 11, 144, -81, 90, -79, 217, -73, -8, 98, -177});
    }
}
