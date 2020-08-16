package programmers.backend;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {

    @Test
    void test() {
        Problem3 sol = new Problem3();

        int[] numbers1 = {10, 40, 30, 20};
        int k1 = 20;

        int[] numbers2 = {3, 7, 2, 8, 6, 4, 5, 1};
        int k2 = 3;

        int result1 = sol.solution(numbers1, k1);
//        int result2 = sol.solution(numbers2, k2);

        assertThat(result1).isEqualTo(1);
//        assertThat(result2).isEqualTo(2);


    }
}