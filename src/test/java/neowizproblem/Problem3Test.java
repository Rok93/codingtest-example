package neowizproblem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void testFunction() {
        //given
        int[] P1 = new int[]{3, 2, 1, 4, 5};
        int[] P2 = new int[]{20,10,10,20};
        int[] P3 = new int[]{103,101,103,103,101,102,100,100,101,104};

        //when
        Problem3 sol = new Problem3();
        int answer1 = sol.solution(P1);
        int answer2 = sol.solution(P2);
        int answer3 = sol.solution(P3);

        //then
        assertThat(answer1).isEqualTo(4);
        assertThat(answer2).isEqualTo(2);
        assertThat(answer3).isEqualTo(7);
    }
}
