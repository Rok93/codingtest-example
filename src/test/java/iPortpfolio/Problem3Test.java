package iPortpfolio;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {
    @Test
    void name() {
        //given
        Problem3 sol = new Problem3();
        String s1 = "baabaa";
        String s2 = "cdcd";

        //when
//        int answer1 = sol.solution(s1);
        int answer2 = sol.solution(s2);

        //then
//        assertThat(answer1).isEqualTo(1);
        assertThat(answer2).isEqualTo(0);
    }
}
