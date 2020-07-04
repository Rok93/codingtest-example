package bootcamp2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    @Test
    void testFunction() {
        //given
        int[] arrayA1 = {1, 2, 3, 2};
        int[] arrayB1 = {1, 3};
        int[] arrayA2 = {2, 3, 4, 3, 5};
        int[] arrayB2 = {1, 6, 7};
        Problem2 sol = new Problem2();

        //when
        int[] answer1 = sol.solution(arrayA1, arrayB1);
        int[] answer2 = sol.solution(arrayA2, arrayB2);

        //then
        assertThat(answer1).isEqualTo(new int[]{3, 2, 3, 1, 2});
        assertThat(answer2).isEqualTo(new int[]{4, 3, 7, 4, 0});
    }
}
