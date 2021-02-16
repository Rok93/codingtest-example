package wootech3rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WooProblem1Test {
    @Test
    void name() {
        //given
        String[] grades1 = {"A+", "D+", "F", "C0"};
        String[] grades2 = {"B+", "A0", "C+"};

        int[] weights1 = {2, 5, 10, 3};
        int[] weights2 = {6, 7, 8};

        int threshold1 = 50;
        int threshold2 = 200;

        //when
        WooProblem1 sol = new WooProblem1();
        int answer1 = sol.solution(grades1, weights1, threshold1);
        int answer2 = sol.solution(grades2, weights2, threshold2);

        //then
        assertThat(answer1).isEqualTo(5);
        assertThat(answer2).isEqualTo(-41);
    }
}
