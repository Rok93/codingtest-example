package p20201011;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestProblem1Test {
    @DisplayName("N으로 표현 문제 풀이 ")
    @Test
    void test() {
        //given
        int N1 = 5;
        int N2 = 2;

        int number1 = 12;
        int number2 = 11;

        //when
        TestProblem1 sol = new TestProblem1();
        int answer1 = sol.solution(N1, number1);
        int answer2 = sol.solution(N2, number2);

        //then
        assertThat(answer1).isEqualTo(4);
        assertThat(answer2).isEqualTo(3);
    }
}
