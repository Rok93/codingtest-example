package practice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem8Test {

    @Test
    void test() {
        Problem8 sol = new Problem8();
        int n = 4;

        int answer = sol.solution(n);

        assertThat(answer).isEqualTo(5);
    }
}