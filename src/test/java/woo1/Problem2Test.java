package woo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {
    @DisplayName("우테코1기 2번문제의 풀이를 테스트한다 ")
    @Test
    void testFuntion() {
        //given
        int[][] lands = {{0, 30, 20, 50}, {30, 30, 40, 40}};
        int[][] wells = {{15, 15, 25, 25}, {40, 10, 50, 20}};
        int[] points = {10, 10, 30, 30};

        Problem2 sol = new Problem2();

        //when
        boolean answer = sol.solution(lands, wells, points);

        //then
        assertThat(answer).isTrue();
    }
}
