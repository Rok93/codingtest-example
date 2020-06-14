package practice.kakao2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {

    @DisplayName("문자열 압축 테스트")
    @Test
    public void test_Solution() {
        //given
        Problem1 sol = new Problem1();
        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";

        //when
        int answer1 = sol.solution(s1);
        int answer2 = sol.solution(s2);
        int answer3 = sol.solution(s3);
        int answer4 = sol.solution(s4);
        int answer5 = sol.solution(s5);

        //then
        assertThat(answer1).isEqualTo(7);
        assertThat(answer2).isEqualTo(9);
        assertThat(answer3).isEqualTo(8);
        assertThat(answer4).isEqualTo(14);
        assertThat(answer5).isEqualTo(17);
    }
}