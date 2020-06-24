package iPortpfolio;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
    @Test
    void testFunction() {
        //given
        Problem1 sol = new Problem1();
        String plain1 = "abab";
        String plain2 = "abcde";
        String plain3 = "abcba";
        String plain4 = "abba";
        String plain5 = "";

        //when
        int answer1 = sol.solution(plain1);
        int answer2 = sol.solution(plain2);
        int answer3 = sol.solution(plain3);
        int answer4 = sol.solution(plain4);
        int answer5 = sol.solution(plain5);

        //then
        assertThat(answer1).isEqualTo(5);
        assertThat(answer2).isEqualTo(9);
        assertThat(answer3).isEqualTo(5);
        assertThat(answer4).isEqualTo(4);
        assertThat(answer5).isEqualTo(0);
    }
}
