package wootech1st20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    @Test
    void name() {
        //given
        int[][] lands = {{0, 30, 20, 50}, {30, 30, 40, 40}};
        int[][] wells = {{15, 15, 25, 25}, {40, 10, 50, 20}};
        int[] point = {10, 10, 30, 30};

        //when
        Problem2 sol = new Problem2();
        boolean answer = sol.solution(lands, wells, point);

        //then
        assertThat(answer).isTrue();
    }
}
