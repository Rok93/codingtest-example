package practice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {
    
    private final Problem5 sol = new Problem5();

    @Test
    void test한다() {
        //given
        String s1 = "AB";
        String s2 = "z";
        String s3 = "a B z";

        //when
        String answer1 = sol.solution(s1, 1);
        String answer2 = sol.solution(s2, 1);
        String answer3 = sol.solution(s3, 4);

        //then
        assertThat(answer1).isEqualTo("BC");
        assertThat(answer2).isEqualTo("a");
        assertThat(answer3).isEqualTo("e F d");
    }
}