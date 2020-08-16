package practice.kakao2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    @DisplayName("괄호변환 기능을 테스트한다")
    @Test
    void test_solution() {
        //given
        Problem2 sol = new Problem2();
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        //when
        String answer1 = sol.solution(p1);
        String answer2 = sol.solution(p2);
        String answer3 = sol.solution(p3);

        //given
        assertThat(answer1).isEqualTo("(()())()");
        assertThat(answer2).isEqualTo("()");
        assertThat(answer3).isEqualTo("()(())()");
    }
}