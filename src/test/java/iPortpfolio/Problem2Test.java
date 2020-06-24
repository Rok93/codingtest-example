package iPortpfolio;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {
    @Test
    void testFunction() {
        //given
        Problem2 sol = new Problem2();
        int[] arrA1 = new int[]{7, 8, 10};
        int[] arrB1 = new int[]{10, 7, 8};

        int[] arrA2 = new int[]{4, 3, 2, 1};
        int[] arrB2 = new int[]{5, 4, 1, 2};
        int[] arrA3 = new int[]{1, 2, 3, 4};
        int[] arrB3 = new int[]{2, 3, 4, 5};
        int[] arrA4 = new int[]{};
        int[] arrB4 = new int[]{2, 3, 4, 5};

        //when
        boolean answer1 = sol.solution(arrA1, arrB1);
        boolean answer2 = sol.solution(arrA2, arrB2);
        boolean answer3 = sol.solution(arrA3, arrB3);
        boolean answer4 = sol.solution(arrA4, arrB4);

        //then
        assertThat(answer1).isTrue();
        assertThat(answer2).isFalse();
        assertThat(answer3).isFalse();
        assertThat(answer4).isFalse();
    }
}
