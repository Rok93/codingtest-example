package practice.kakao2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {

    @DisplayName("자물쇠와 열쇠 기능을 테스트한다.")
    @Test
    void test_Solution() {
        //given
        Problem4 sol = new Problem4();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        //when
        boolean answer = sol.solution(key, lock);

        assertThat(answer).isTrue();
    }
}