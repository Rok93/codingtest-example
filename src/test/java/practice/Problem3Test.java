package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {

    private Problem3 sol = new Problem3();

    @DisplayName("수박을 출력한다")
    @Test
    void testWaterMelon() {
        //given
        int n1 = 3;
        int n2 = 4;

        //when
        String answer1 = sol.solution(n1);
        String answer2 = sol.solution(n2);

        //then
        assertThat(answer1).isEqualTo("수박수");
        assertThat(answer2).isEqualTo("수박수박");
    }
}