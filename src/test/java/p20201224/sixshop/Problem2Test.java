package p20201224.sixshop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem2Test {

    @Test
    void test() {
        //given
        int[] grade1 = {2, 2, 1};
        int[] grade2 = {3, 2, 1, 2};

        //when
        Problem2 sol = new Problem2();
        int[] s1 = sol.solution(grade1);
        int[] s2 = sol.solution(grade2);

        //then
        assertThat(s1).isEqualTo(new int[]{1, 1, 3});
        assertThat(s2).isEqualTo(new int[]{1, 2, 4, 2});
    }
}
