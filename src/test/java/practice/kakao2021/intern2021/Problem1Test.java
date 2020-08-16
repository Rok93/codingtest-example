package practice.kakao2021.intern2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @DisplayName("1번 문제를 테스트 한다")
    @Test
    void test_Solution() {
        //given
        Problem1 sol = new Problem1();
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";

        //when
        String answer1 = sol.solution(numbers1, hand1);
        String answer2 = sol.solution(numbers2, hand2);
        String answer3 = sol.solution(numbers3, hand3);

        //then
        assertThat(answer1).isEqualTo("LRLLLRLLRRL");
        assertThat(answer2).isEqualTo("LRLLRRLLLRR");
        assertThat(answer3).isEqualTo("LLRLLRLLRL");
    }
}