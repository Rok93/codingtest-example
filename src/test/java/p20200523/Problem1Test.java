package p20200523;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void test_Function() {
        //given
        Problem1 sol = new Problem1();
        int P1 = 1987;
        int P2 = 2015;
        //when
        int answer1 = sol.solution(P1);
        int answer2 = sol.solution(P2);

        //then
        assertThat(answer1).isEqualTo(2013);
        assertThat(answer2).isEqualTo(2016);
    }
}