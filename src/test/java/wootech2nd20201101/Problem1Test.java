package wootech2nd20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    void name() {
        //given
        int[] restaurant = {0, 0};
        int[][] riders = {{-700, 0}, {150, 180}, {500, 500}, {150, -800}, {800, 800}, {-900, 500}, {-1100, 900}};
        int k = 1000;

        //when
        Problem1 sol = new Problem1();
        int answer = sol.solution(restaurant, riders, k);

        //then
        assertThat(answer).isEqualTo(4);
    }
}
