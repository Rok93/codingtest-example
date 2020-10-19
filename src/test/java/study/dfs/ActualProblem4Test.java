package study.dfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ActualProblem4Test {
    @DisplayName("괄호 변환 문제 풀이 ")
    @Test
    void testInit() {
        //given
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        //when
        ActualProblem4 sol = new ActualProblem4();
//        String answer1 = sol.solution(p1);
//        String answer2 = sol.solution(p2);
        String answer3 = sol.solution(p3);

        //then
//        assertThat(answer1).isEqualTo("(()())()");
//        assertThat(answer2).isEqualTo("()");
        assertThat(answer3).isEqualTo("()(())()");
    }
}
