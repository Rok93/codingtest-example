package woo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {
    @DisplayName("우테코1기 5번문제 풀이를 테스트한다 ")
    @Test
    void testFunction() {
        //given
        int number1 = 13;
        int number2 = 33;

        Problem5 sol = new Problem5();

        //when
        int answer1 = sol.solution(number1);
        int answer2 = sol.solution(number2);

        //then
        assertThat(answer1).isEqualTo(4);
        assertThat(answer2).isEqualTo(14);
    }
}
