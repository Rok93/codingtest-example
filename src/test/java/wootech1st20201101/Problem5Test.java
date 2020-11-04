package wootech1st20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {
    @Test
    void name() {
        //given
        int number1 = 13;
        int number2 = 33;

        //when
        Problem5 sol = new Problem5();
        int answer1 = sol.solution(number1);
        int answer2 = sol.solution(number2);

        //then
        assertThat(answer1).isEqualTo(4);
        assertThat(answer2).isEqualTo(14);
    }
}
