package naver2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NaverProblem1Test {

    @DisplayName("네이버 1번 문제 풀이 !")
    @Test
    void name() {
        //given
        String m1 = "kkaxbycyz";
        String k1 = "abc";
        String m2 = "acbbcdc";
        String k2 = "abc";

        //when
        NaverProblem1 sol = new NaverProblem1();
        String answer1 = sol.solution(m1, k1);
        String answer2 = sol.solution(m2, k2);


        //then
        assertThat(answer1).isEqualTo("kkxyyz");
        assertThat(answer2).isEqualTo("cbdc");
    }
}
