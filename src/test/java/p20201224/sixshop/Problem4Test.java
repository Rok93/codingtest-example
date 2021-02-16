package p20201224.sixshop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {

    @Test
    void test() {
        //given
        int n1 = 3;
        int[] coffee_times1 = {4, 2, 2, 5, 3};

        int n2 = 1;
        int[] coffee_times2 = {100, 1, 50, 1, 1};

        //when
        Problem4 sol = new Problem4();
        int[] a1 = sol.solution(n1, coffee_times1);
        int[] a2 = sol.solution(n2, coffee_times2);

        //then
        assertThat(a1).isEqualTo(new int[]{2, 3, 1, 5, 4});
        assertThat(a2).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }
}
