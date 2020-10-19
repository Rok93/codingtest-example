package study.implementation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ActualProblem6Test {
    @Test
    void testFunction() {
        //given
        int n1 = 12;
        int n2 = 12;
        int[] weak1 = {1, 5, 6, 10};
        int[] weak2 = {1, 3, 4, 9, 10};
        int[] dist1 = {1, 2, 3, 4};
        int[] dist2 = {3, 5, 7};


        //when
        ActualProblem6 sol = new ActualProblem6();
        int solution1 = sol.solution(n1, weak1, dist1);
        int solution2 = sol.solution(n2, weak2, dist2);

        //then
        assertThat(solution1).isEqualTo(2);
        assertThat(solution2).isEqualTo(1);
    }
}
