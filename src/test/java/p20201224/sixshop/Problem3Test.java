package p20201224.sixshop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {

    @Test
    void test() {
        //given
        int n1 = 15;
        int n2 = 7;

        //when
        Problem3 sol = new Problem3();
        int a1 = sol.solution(n1);
        int a2 = sol.solution(n2);

        //then
        assertThat(a1).isEqualTo(3);
        assertThat(a2).isEqualTo(-1);
    }
}
