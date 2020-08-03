package p20200803;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @DisplayName("입국심사 문제 풀이를 테스트한다 ")
    @Test
    void testFunction() {
        //given
        int n = 6;
        int[] times = {7, 10};
        Problem1 sol = new Problem1();

        //when
        long answer = sol.solution(n, times);

        //then
        assertThat(answer).isEqualTo(28L);
    }
}
