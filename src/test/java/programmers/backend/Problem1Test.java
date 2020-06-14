package programmers.backend;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    void test() {
        Problem1 sol = new Problem1();

        String P = "82195";
        String S = "64723";

        int answer = sol.solution(P, S);

        assertThat(answer).isEqualTo(13);
    }
}