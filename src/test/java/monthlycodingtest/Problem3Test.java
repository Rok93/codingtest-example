package monthlycodingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {

    @Test
    void test() {
        //given
        int[] a1 = {-5, 0, 2, 1, 2};
        int[] a2 = {0, 1, 0};
        int[][] edges1 = {{0, 1}, {3, 4}, {2, 3}, {0, 3}};
        int[][] edges2 = {{0, 1}, {1, 2}};

        //when
        Problem3 sol = new Problem3();
        long answer1 = sol.solution(a1, edges1);
        long answer2 = sol.solution(a2, edges2);

        //then
        assertThat(answer1).isEqualTo(9);
        assertThat(answer2).isEqualTo(-1);
    }
}
