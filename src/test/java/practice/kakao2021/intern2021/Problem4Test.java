package practice.kakao2021.intern2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @DisplayName("4번문제를 테스트한다.")
    @Test
    void test_Solution() {
        //given
        Problem4 sol = new Problem4();
        int[][] board1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board2 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int[][] board3 = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int[][] board4 = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};


        //when
        int answer1 = sol.solution(board1);
        int answer2 = sol.solution(board2);
        int answer3 = sol.solution(board3);
        int answer4 = sol.solution(board4);

        //then
        assertThat(answer1).isEqualTo(900);
        assertThat(answer2).isEqualTo(3800);
        assertThat(answer3).isEqualTo(2100);
        assertThat(answer4).isEqualTo(3200);

    }
}