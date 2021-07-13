package kakaopay2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class KakaoPayProblem2Test {

    @Test
    void test2() {
        //given
        int rows1 = 4;
        int columns1 = 3;
        int[][] swipes1 = {{1, 1, 2, 4, 3}, {3, 2, 1, 2, 3}, {4, 1, 1, 4, 3}, {2, 2, 1, 3, 3}};
        int[] result1 = {23, 3, 21, 9};

        int rows2 = 2;
        int columns2 = 4;
        int[][] swipes2 = {{3, 1, 2, 2, 4}, {3, 1, 2, 2, 4}, {4, 2, 1, 2, 3}, {1, 1, 1, 2, 3}};
        int[] result2 = {12, 10, 5, 20};

        int rows3 = 2;
        int columns3 = 2;
        int[][] swipes3 = {{3, 1, 1, 1, 2}, {1, 1, 2, 2, 2}, {4, 2, 1, 2, 2}, {2, 1, 1, 2, 1}};
        int[] result3 = {2, 4, 3, 2};

        //when
        KakaoPayProblem2 solution = new KakaoPayProblem2();
        int[] answer1 = solution.solution(rows1, columns1, swipes1);
        int[] answer2 = solution.solution(rows2, columns2, swipes2);
        int[] answer3 = solution.solution(rows3, columns3, swipes3);

        //then
        assertThat(answer1).isEqualTo(result1);
        assertThat(answer2).isEqualTo(result2);
        assertThat(answer3).isEqualTo(result3);
    }
}
