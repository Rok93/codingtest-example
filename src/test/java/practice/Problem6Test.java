package practice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    private final Problem6 sol = new Problem6();

    @Test
    void testProblem6() {
        //given
        int n1 = 12;
        int n2 = 5;

        //when
        int answer1 = sol.solution(n1);
        int answer2 = sol.solution(n2);

        //then
        assertThat(answer1).isEqualTo(28);
        assertThat(answer2).isEqualTo(6);
    }
}