package woo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
    @DisplayName("우테코1기 1번 문제 풀이 테스트")
    @Test
    void testFunction() {
        //given
        int money1 = 50237;
        int money2 = 15000;

        Problem1 sol = new Problem1();
        //when
        int[] answer1 = sol.solution(money1);
        int[] answer2 = sol.solution(money2);

        //then
        assertThat(answer1).isEqualTo(new int[]{1, 0, 0, 0, 0, 2, 0, 3, 7});
        assertThat(answer2).isEqualTo(new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0});
    }
}
