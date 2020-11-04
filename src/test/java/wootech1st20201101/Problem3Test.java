package wootech1st20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void name() {
        //given
        String word = "I love you";

        //when
        Problem3 sol = new Problem3();
        String answer = sol.solution(word);

        //then
        assertThat(answer).isEqualTo("R olev blf");
    }
}
