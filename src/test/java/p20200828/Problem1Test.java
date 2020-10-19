package p20200828;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
    @Test
    void testFunction() {
        //given
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        //when
        Problem1 sol = new Problem1();
        int[] answer = sol.solution(array, commands);

        //then
        assertThat(answer).isEqualTo(new int[]{5, 6, 3});
    }
}
