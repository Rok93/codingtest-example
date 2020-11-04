package wootech1st20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @Test
    void name() {
        //given
        int[] pobi1 = {97, 98};
        int[] crong1 = {197, 198};
        int[] pobi2 = {131, 132};
        int[] crong2 = {211, 212};
        int[] pobi3 = {99, 102};
        int[] crong3 = {211, 212};


        //when
        Problem4 sol = new Problem4();
        int answer1 = sol.solution(pobi1, crong1);
        int answer2 = sol.solution(pobi2, crong2);
        int answer3 = sol.solution(pobi3, crong3);

        //then
        assertThat(answer1).isEqualTo(0);
        assertThat(answer2).isEqualTo(1);
        assertThat(answer3).isEqualTo(-1);
    }
}
