package nhngodocodingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NhnGodoProblem2Test {
    @Test
    void test() {
        //given
        int page1 = 5457;
        int[] broken1 = {6,7,8};
        int page2 = 100;
        int[] broken2 = {1,0,5};
        int page3 = 99999;
        int[] broken3 = {0,2,3,4,5,6,7,8,9};
        int page4 = 158;
        int[] broken4 = {1,9,2,5,4};
        int page5 = 151241;
        int[] broken5 = {0,1,2,3,4,7,8,9};

        //when
        NhnGodoProblem2 sol = new NhnGodoProblem2();
        int answer1 = sol.solution(page1, broken1);
        int answer2 = sol.solution(page2, broken2);
        int answer3 = sol.solution(page3, broken3);
        int answer4 = sol.solution(page4, broken4);
        int answer5 = sol.solution(page5, broken5);

        //then
        assertThat(answer1).isEqualTo(6);
        assertThat(answer2).isEqualTo(0);
        assertThat(answer3).isEqualTo(11118);
        assertThat(answer4).isEqualTo(58);
        assertThat(answer5).isEqualTo(84580);
    }
}
