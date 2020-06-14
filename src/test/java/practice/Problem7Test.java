package practice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem7Test {

    @Test
    void test() {
        Problem7 sol = new Problem7();
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;

        int[] answer1 = sol.solution(n1);
        int[] answer2 = sol.solution(n2);
        int[] answer3 = sol.solution(n3);

        assertThat(answer1).isEqualTo(new int[]{0});
        assertThat(answer2).isEqualTo(new int[]{0, 0, 1});
        assertThat(answer3).isEqualTo(new int[]{0, 0, 1, 0, 0, 1, 1});
        // 1 --> 0
        // 2 --> 0 0 1
        // 3 -->
    }
}