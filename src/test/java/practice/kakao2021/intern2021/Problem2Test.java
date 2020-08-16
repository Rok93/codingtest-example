package practice.kakao2021.intern2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    @DisplayName("2번문제를 테스트한다.")
    @Test
    void test_Solution() {
        //given
        Problem2 sol = new Problem2();
        String expression1 = "100-200*300-500+20";
        String expression2 = "50*6-3*2";

        //when
        long answer1 = sol.solution(expression1);
        long answer2 = sol.solution(expression2);

        //then
        assertThat(answer1).isEqualTo(60420L);
        assertThat(answer2).isEqualTo(300L);

    }
}