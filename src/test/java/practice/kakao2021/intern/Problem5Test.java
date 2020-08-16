package practice.kakao2021.intern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {
    @DisplayName("징검다리 건너기 기능을 테스트한다")
    @Test
    void test_Solution() {
        //given
        Problem5 sol = new Problem5();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        //when
        int answer = sol.solution(stones, k);

        //then
        assertThat(answer).isEqualTo(3);
    }
}