package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    private final Problem4 sol = new Problem4();

    @DisplayName("문자열을 숫자로 출력합니다")
    @Test
    void testProblem4() {
        //given
        String s1 = "1234";
        String s2 = "-1234";

        //when
        int answer1 = sol.solution(s1);
        int answer2 = sol.solution(s2);

        //then
        assertThat(answer1).isEqualTo(1234);
        assertThat(answer2).isEqualTo(-1234);
    }
}