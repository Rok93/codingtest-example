package wootech1st20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem7Test {
    @Test
    void name() {
        //given
        String cryptogram = "browoanoommnaon";
        String cryptogram2 = "zyelleyz";

        //when
        Problem7 sol = new Problem7();
        String answer = sol.solution(cryptogram);
        String answer2 = sol.solution(cryptogram2);

        //then
        assertThat(answer).isEqualTo("brown");
        assertThat(answer2).isEqualTo("");
    }
}
