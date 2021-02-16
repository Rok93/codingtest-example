package p20201224.sixshop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem1Test {
    @Test
    void test() {
        //given
        String s1 = "xyZA";
        String s2 = "ABCxy";

        String s3 = "AxA";
        String s4 = "AyA";

        String s5 = "ABCDEF";
        String s6 = "G";


        //when
        Problem1 problem1 = new Problem1();
//        String a1 = problem1.solution(s1, s2);
//        String a2 = problem1.solution(s3, s4);
        String a3 = problem1.solution(s5, s6);

        //then
//        assertThat(a1).isEqualTo("ABCxyZA");
//        assertThat(a2).isEqualTo("AxAyA");
        assertThat(a3).isEqualTo("ABCDEFG");
    }
}
