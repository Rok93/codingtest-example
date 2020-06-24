package neowizproblem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {
    @Test
    void testFunction() throws Exception {
        //given
        String expression1 = "2-1x5-4x3+2";
        String expression2 = "2x3-1";

        //when
        Problem1 sol = new Problem1();
        long answer1 = sol.solution(expression1);
        long answer2 = sol.solution(expression2);

        //then
        assertThat(answer1).isEqualTo(11L);
        assertThat(answer2).isEqualTo(5L);


    }
}
