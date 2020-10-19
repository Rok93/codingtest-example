package coupang2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoupangProblem3Test {
    @DisplayName("쿠팡 3번문제 풀이 ")
    @Test
    void name() {
        //given
        int k1 = 3;
        int k2 = 2;

        int[] score1 = {24, 22, 20, 10, 5, 3, 2, 1};
        int[] score2 = {1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486, 157658638, 157658634, 100000000, 100};

        //when
        CoupangProblem3 sol = new CoupangProblem3();
//        int answer1 = sol.solution(k1, score1);
        int answer2 = sol.solution(k2, score2);

        //then
//        assertThat(answer1).isEqualTo(3);
        assertThat(answer2).isEqualTo(4);
    }
}
