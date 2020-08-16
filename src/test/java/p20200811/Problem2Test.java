package p20200811;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    @DisplayName("프로그래머스 징검다리 문제 풀이를 검증한다 ")
    @Test
    void testFunction() {
        //given
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        //when
        Problem2 sol = new Problem2();
        int answer = sol.solution(distance, rocks, n);

        //then
        assertThat(answer).isEqualTo(4);
    }
}
