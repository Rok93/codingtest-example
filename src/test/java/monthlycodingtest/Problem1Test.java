package monthlycodingtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @Test
    void test() {
        //given
        int[] absolutes1 = {4, 7, 12};
        boolean[] signs1 = {true, false, true};

        int[] absolutes2 = {1, 2, 3};
        boolean[] signs2 = {false, false, true};
        Problem1 sol = new Problem1();

        //when
        int answer1 = sol.solution(absolutes1, signs1);
        int answer2 = sol.solution(absolutes2, signs2);

        //then
        assertThat(answer1).isEqualTo(9);
        assertThat(answer2).isEqualTo(0);
    }
}
