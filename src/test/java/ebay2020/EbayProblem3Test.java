package ebay2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EbayProblem3Test {
    @Test
    void name() {
        //given
        int n1 = 2;
        int n2 = 3;

        int[][] products1 = {{10, 3, 2}, {15, 2, 5}};
        int[][] products2 = {{6, 5, 1}, {11, 3, 2}, {7, 10, 3}};

        //when
        EbayProblem3 sol = new EbayProblem3();
//        long answer1 = sol.solution(n1, products1);
        long answer2 = sol.solution(n2, products2);

        //then
//        assertThat(answer1).isEqualTo(48);
        assertThat(answer2).isEqualTo(120);
    }
}
