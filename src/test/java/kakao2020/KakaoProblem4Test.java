package kakao2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KakaoProblem4Test {
    @DisplayName("4번문제 풀이")
    @Test
    void name() {
        //given
        int n1 = 6;
        int n2 = 7;
        int n3 = 6;
        int[][] fares1 = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        int s1 = 4;
        int s2 = 3;
        int s3 = 4;
        int[][] fares2 = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};

        int a1 = 6;
        int a2 = 4;
        int a3 = 5;
        int[][] fares3 = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};

        int b1 = 2;
        int b2 = 1;
        int b3 = 6;

        //when
        KakaoProblem4 sol = new KakaoProblem4();
        int answer1 = sol.solution(n1, s1, a1, b1, fares1);
        int answer2 = sol.solution(n2, s2, a2, b2, fares2);
        int answer3 = sol.solution(n3, s3, a3, b3, fares3);

        //then
        assertThat(answer1).isEqualTo(82);
        assertThat(answer2).isEqualTo(14);
        assertThat(answer3).isEqualTo(18);
    }
}
