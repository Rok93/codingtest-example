package coupang2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoupangProblem1Test {

    @DisplayName("쿠팡 1번문제 풀이!")
    @Test
    void name() {
        //given
        int N1 = 10;
        int N2 = 14;

        //when
        CoupangProblem1 sol = new CoupangProblem1();
        int[] answer1 = sol.solution(N1);
        int[] answer2 = sol.solution(N2);

        //then
        assertThat(answer1).isEqualTo(new int[]{6, 4});
        assertThat(answer2).isEqualTo(new int[]{5, 8});
    }
}
