package p20200823.socar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SocarProblem3Test {
    @DisplayName("쏘카 3번 문제 풀이 ")
    @Test
    void testFunction() {
        //given
        int r1 = 3;
        int[][] delivery1 = {{1, 5}, {8, 3}, {4, 2}, {2, 3}, {3, 1}, {3, 2}, {4, 2}, {5, 2}, {4, 1}};

        int r2 = 4;
        int[][] delivery2 = {{1, 10}, {8, 1}, {8, 1}, {3, 100}, {8, 1}, {8, 1}, {8, 1}, {8, 1}, {8, 1}
                , {8, 1}, {8, 1}, {8, 1}, {9, 100}, {8, 1}, {8, 1}, {8, 1}};

        //when
        SocarProblem3 sol = new SocarProblem3();
//        int answer1 = sol.solution(r1, delivery1); // timeLimit: 8
        int answer2 = sol.solution(r2, delivery2); // timeLimit: 9

        //then
//        assertThat(answer1).isEqualTo(17);
        assertThat(answer2).isEqualTo(217);
    }
}
