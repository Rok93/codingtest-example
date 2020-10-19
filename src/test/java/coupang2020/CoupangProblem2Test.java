package coupang2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoupangProblem2Test {
    @DisplayName("쿠팡 2번 문제 풀이 ")
    @Test
    void name() {
        //given
        int n1 = 3;
        int n2 = 2;

        String[] customers1 = {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"};
        String[] customers2 = {"02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01"};

        //when
        CoupangProblem2 sol = new CoupangProblem2();
        int answer1 = sol.solution(n1, customers1);
        int answer2 = sol.solution(n2, customers2);

        //then
        assertThat(answer1).isEqualTo(4);
        assertThat(answer2).isEqualTo(2);
    }
}
