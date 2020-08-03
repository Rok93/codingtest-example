package p20200803;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1_1Test {

    @DisplayName("입국심사 문제 풀이를 테스트한다 ")
    @Test
    void testFunction() {
        //given
        int n = 6;
        int n2 = 13;
        int n3 = 11;
        int[] times = {7, 10};
        int[] times2 = {7, 10, 11};
        int[] times3 = {6, 10};
        int[] times4 = {8, 10};
        int[] times5 = {4, 10};
        int[] times6 = {3, 4, 10};
        int[] times7 = {3, 3, 3};
        Problem1_1 sol = new Problem1_1();

        //when
        long answer = sol.solution(n, times);
        long answer2 = sol.solution(n2, times2);
        long answer3 = sol.solution(n, times3);
        long answer4 = sol.solution(n, times4);
        long answer5 = sol.solution(n, times5);
        long answer6 = sol.solution(n3, times6);
        long answer7 = sol.solution(n, times7);

        //then
        assertThat(answer).isEqualTo(28L);
        assertThat(answer2).isEqualTo(42L);
        assertThat(answer3).isEqualTo(24L);
        assertThat(answer4).isEqualTo(30L);
        assertThat(answer5).isEqualTo(20L);
        assertThat(answer6).isEqualTo(18L);
        assertThat(answer7).isEqualTo(6L);
    }
}
