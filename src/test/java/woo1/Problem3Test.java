package woo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {
    @DisplayName("우테코1기 3번 문제 풀이를 테스트한다 ")
    @Test
    void name() {
        //given
        String word = "I love you";

        Problem3 sol = new Problem3();

        //when
        String answer = sol.solution(word);

        //then
        assertThat(answer).isEqualTo("R olev blf");
    }
}
