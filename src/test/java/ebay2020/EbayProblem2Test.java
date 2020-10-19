package ebay2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EbayProblem2Test {
    @Test
    void name() {
        //given
        int num1 = 8;
        int num2 = 18;
        int[] cards1 = {1, 4, 6};
        int[] cards2 = {1, 2, 5};

        //when
        EbayProblem2 sol = new EbayProblem2();
        int answer1 = sol.solution(num1, cards1);
        int answer2 = sol.solution(num2, cards2);

        //then
        assertThat(answer1).isEqualTo(2);
        assertThat(answer2).isEqualTo(5);
    }
}
