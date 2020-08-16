package p20200811;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @DisplayName("프로그래머스 징검다리 문제 풀이를 검증한다 ")
    @Test
    void testFunction() {
        //given
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        //when
        Problem1 sol = new Problem1();
        int answer = sol.solution(distance, rocks, n);

        //then
        assertThat(answer).isEqualTo(4);
    }
}
