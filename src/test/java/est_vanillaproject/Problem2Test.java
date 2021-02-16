package est_vanillaproject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class Problem2Test {

    @DisplayName("2번문제 답")
    @Test
    void test() {
        //given
        int[] scores1 = {1,3,7,8,10,15};
        int k1 = 3;

        int[] scores2 = {1,2,12,14,15};
        int k2 = 2;

        //when
        Problem2 sol = new Problem2();
        int answer1 = sol.solution(scores1, k1);
        int answer2 = sol.solution(scores2, k2);

        //then
        assertAll(
                () -> assertThat(answer1).isEqualTo(5),
                () -> assertThat(answer2).isEqualTo(4)
        );
    }
}
