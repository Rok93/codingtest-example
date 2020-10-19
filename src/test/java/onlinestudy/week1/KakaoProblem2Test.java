package onlinestudy.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KakaoProblem2Test {
    @Test
    void testFunction() {
        //given
        String p1 = "(()())()";	// "(()())()"
        String p2 = ")(";	//"()"
        String p3 = "()))((()"; //	"()(())()"
        String p4 = "()";	//"()"

        //when
        KakaoProblem2 sol = new KakaoProblem2();
        String answer1 = sol.solution(p1);
        String answer2 = sol.solution(p2);
        String answer3 = sol.solution(p3);
        String answer4 = sol.solution(p4);

        //then
        assertThat(answer1).isEqualTo("(()())()");
        assertThat(answer2).isEqualTo("()");
        assertThat(answer3).isEqualTo("()(())()");
        assertThat(answer4).isEqualTo("()");
    }
}
