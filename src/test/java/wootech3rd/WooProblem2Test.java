package wootech3rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WooProblem2Test {
    @Test
    void name() {
        //given
        String s1 = "1234";
        String s2 = "987987";
        String s3 = "31402";

        String op1 = "+";
        String op2 = "-";
        String op3 = "*";

        //when
        WooProblem2 sol = new WooProblem2();
        long[] answer1 = sol.solution(s1, op1);
        long[] answer2 = sol.solution(s2, op2);
        long[] answer3 = sol.solution(s3, op3);

        //then
        assertThat(answer1).isEqualTo(new long[]{235, 46, 127});
        assertThat(answer2).isEqualTo(new long[]{-87978, -7889, 0, 9792, 98791});
        assertThat(answer3).isEqualTo(new long[]{4206, 12462, 628, 6280});
    }
}
