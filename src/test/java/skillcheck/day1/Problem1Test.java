package skillcheck.day1;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {

    @Test
    public void sol을_테스트하다() {
        int[] nextStep = {1, 2};
        int n1 = 4;
        int n2 = 3;

        Problem1 sol = new Problem1();
        assertThat(5L).isEqualTo(sol.solution(n1));
        assertThat(3L).isEqualTo(sol.solution(n2));
    }
}