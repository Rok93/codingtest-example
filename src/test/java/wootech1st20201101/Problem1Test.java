package wootech1st20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
    @Test
    void name() {
        //given
        int money1 = 50237;
        int money2 = 15000;

        //when
        Problem1 sol = new Problem1();
        int[] answer1 = sol.solution(money1);
        int[] answer2 = sol.solution(money2);

        //then
        assertThat(answer1).isEqualTo(new int[]{1, 0, 0, 0, 0, 2, 0, 3, 7});
        assertThat(answer2).isEqualTo(new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0});
    }
}
