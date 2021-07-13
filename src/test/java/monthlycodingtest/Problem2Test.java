package monthlycodingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void test() {
        //given
        String s1 = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";

        //when
        Problem2 sol = new Problem2();
        int answer1 = sol.solution(s1);
        int answer2 = sol.solution(s2);
        int answer3 = sol.solution(s3);
        int answer4 = sol.solution(s4);

        //then
        assertAll(
                () -> assertThat(answer1).isEqualTo(3),
                () -> assertThat(answer2).isEqualTo(2),
                () -> assertThat(answer3).isEqualTo(0),
                () -> assertThat(answer4).isEqualTo(0)
        );
    }

}
