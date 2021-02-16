package est_vanillaproject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class Problem2_2Test {

    @DisplayName("다른 풀이(이분탐색)로 2번 문제를 푼다")
    @Test
    void name() {
        //given
        int[] scores1 = {1,3,7,8,10,15};
        int k1 = 3;

        int[] scores2 = {1,2,12,14,15};
        int k2 = 2;

        //when
        Problem2_2 sol = new Problem2_2();
        int answer1 = sol.solution(scores1, k1);
        int answer2 = sol.solution(scores2, k2);

        //then
        //then
        assertAll(
                () -> assertThat(answer1).isEqualTo(5),
                () -> assertThat(answer2).isEqualTo(4)
        );
    }
}
