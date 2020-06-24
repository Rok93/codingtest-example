package neowizproblem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    @Test
    void testFunction() {
        //given
        int[] s1 = new int[]{1, 2, 3};
        int[] s2 = new int[]{3, -1, 0, 4};
        int[] s3 = new int[]{2, 0, 1, 3, 5};
        int[] s4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] s5 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] s6 = new int[]{1, 3, 2, 4, -1, 5, -2, 6};
        int[] s7 = new int[]{9, 1, 3, 2, 4, -1, 5, -2, 6};

        //when
        Problem2 sol = new Problem2();
        int result1 = sol.solution(s1);
        int result2 = sol.solution(s2);
        int result3 = sol.solution(s3);
        int result4 = sol.solution(s4);
        int result5 = sol.solution(s5);
        int result6 = sol.solution(s6);
        int result7 = sol.solution(s7);

        //then
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(3);
        assertThat(result4).isEqualTo(7);
        assertThat(result5).isEqualTo(8);
        assertThat(result6).isEqualTo(0);
        assertThat(result7).isEqualTo(1);
    }
}
