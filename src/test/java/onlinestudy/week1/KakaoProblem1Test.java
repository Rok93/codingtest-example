package onlinestudy.week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem1Test {
    @DisplayName("카카오 문자열 압출 문제 풀이 ")
    @Test
    void testFunction() {
        //given
        String s1 = "aabbaccc"; //	7
        String s2 = "ababcdcdababcdcd"; //	9
        String s3 = "abcabcdede"; // 	8
        String s4 = "abcabcabcabcdededededede";//	14
        String s5 = "xababcdcdababcdcd"; //17

        //when
        KakaoProblem1 sol = new KakaoProblem1();
        int solution1 = sol.solution(s1);
        int solution2 = sol.solution(s2);
        int solution3 = sol.solution(s3);
        int solution4 = sol.solution(s4);
        int solution5 = sol.solution(s5);

        //then
        assertThat(solution1).isEqualTo(7);
        assertThat(solution2).isEqualTo(9);
        assertThat(solution3).isEqualTo(8);
        assertThat(solution4).isEqualTo(14);
        assertThat(solution5).isEqualTo(17);
    }
}
