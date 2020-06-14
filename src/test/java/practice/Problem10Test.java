package practice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem10Test {

    @Test
    void test() {
        Problem10 sol = new Problem10();

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] answer = sol.solution(m, n, picture);

        assertThat(answer).isEqualTo(new int[]{4, 5});
    }
}