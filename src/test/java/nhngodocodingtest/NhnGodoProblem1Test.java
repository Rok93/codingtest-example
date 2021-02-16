package nhngodocodingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NhnGodoProblem1Test {
    @Test
    void test() {
        //given
        int[] goods1 = {46, 62, 9};
        int[] goods2 = {50, 62, 93};
        int[] goods3 = {5, 31, 15};

        //when
        NhnGodoProblem1 sol = new NhnGodoProblem1();
        int answer1 = sol.solution(goods1);
        int answer2 = sol.solution(goods2);
        int answer3 = sol.solution(goods3);

        //then
        assertThat(answer1).isEqualTo(97);
        assertThat(answer2).isEqualTo(175);
        assertThat(answer3).isEqualTo(41);

    }
}
