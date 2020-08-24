package study.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {
    @DisplayName("무지의 먹방 라이브 문제 풀이를 테스트한다 ")
    @Test
    void testFunction() {
        //given
        int[] food_times = {3, 1, 2};
        int k = 5;

        Problem5 sol = new Problem5();
        //when
        int answer = sol.solution(food_times, k);

        //then
        assertThat(answer).isEqualTo(1);
    }
}
