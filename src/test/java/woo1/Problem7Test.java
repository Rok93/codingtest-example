package woo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {
    @DisplayName("우테코 1기 7번 문제 풀이를 테스트한다 ")
    @Test
    void testFunction() {
        //given
        String cryptogram1 = "browoanoommnaon";
        String cryptogram2 = "zyelleyz";

        Problem7 sol = new Problem7();

        //when
        String answer1 = sol.solution(cryptogram1);
        String answer2 = sol.solution(cryptogram2);

        //then
        assertThat(answer1).isEqualTo("brown");
        assertThat(answer2).isEqualTo("");

    }
}
