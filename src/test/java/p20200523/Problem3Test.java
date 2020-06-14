package p20200523;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void test_Function() {
        //given
        Problem3 sol = new Problem3();
        int total_sp = 121;
        int[][] skills = new int[][]{{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};

        //when
        int[] answer = sol.solution(total_sp, skills);
        //then
        assertThat(answer).isEqualTo(new int[]{44, 11, 33, 11, 11, 11});

    }
}