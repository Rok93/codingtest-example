package p20200523;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    @Test
    void test_Function() {
        //given
        Problem2 sol = new Problem2();
        long n1 = 4L;
        long n2 = 11L;

        //when
        long answer1 = sol.solution(n1);
        long answer2 = sol.solution(n2);

        //then
        assertThat(answer1).isEqualTo(9L);
        assertThat(answer2).isEqualTo(31L);
    }
}