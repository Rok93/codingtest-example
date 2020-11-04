package wootech2nd20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void name() {
        //given
        int[] prices1 = {13000, 88000, 10000};
        int[] prices2 = {32000, 18000, 42500};

        int[] discounts1 = {30, 20};
        int[] discounts2 = {50, 20, 65};

        //when
        Problem3 sol = new Problem3();
        int answer1 = sol.solution(prices1, discounts1);
        int answer2 = sol.solution(prices2, discounts2);

        //then
        assertThat(answer1).isEqualTo(82000);
        assertThat(answer2).isEqualTo(45275);

    }
}
