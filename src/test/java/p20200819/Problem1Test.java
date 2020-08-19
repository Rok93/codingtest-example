package p20200819;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {
    @Test
    void testFunction() {
        //given
        int n1 = 5;
        int n2 = 5;
        int n3 = 3;

        int[] lost1 = {2,4};
        int[] lost2 = {2,4};
        int[] lost3 = {3};

        int[] reserve1 = {1,3,5};
        int[] reserve2 = {3};
        int[] reserve3 = {1};

        Problem1 sol = new Problem1();

        //when
        int answer1 = sol.solution(n1, lost1, reserve1);
        int answer2 = sol.solution(n2, lost2, reserve2);
        int answer3 = sol.solution(n3, lost3, reserve3);

        //then
        assertThat(answer1).isEqualTo(5);
        assertThat(answer2).isEqualTo(4);
        assertThat(answer3).isEqualTo(2);

    }
}
