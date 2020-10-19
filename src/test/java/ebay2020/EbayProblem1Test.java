package ebay2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EbayProblem1Test {
    @Test
    void name() {
        //given
        int N1 = 2;
        int N2 = 1;
        int[][] simulation_data1 = {{0, 3}, {2, 5}, {4, 2}, {5, 3}};
        int[][] simulation_data2 = {{2, 3}, {5, 4}, {6, 3}, {7, 4}};

        //when
        EbayProblem1 sol = new EbayProblem1();
        int answer1 = sol.solution(N1, simulation_data1);
//        int answer2 = sol.solution(N2, simulation_data2);

        //then
        assertThat(answer1).isEqualTo(1);
//        assertThat(answer2).isEqualTo(8);
    }
}
