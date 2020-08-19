package woo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {
    @DisplayName("우테코1기 4번 문제 풀이를 테스트한다 ")
    @Test
    void name() {
        //given
        int[] pobi1 = {97, 98};
        int[] pobi2 = {131, 132};
        int[] pobi3 = {99, 102};
        int[] pobi4 = {100, 101};

        int[] crong1 = {197, 198};
        int[] crong2 = {211, 212};
        int[] crong3 = {211, 212};
        int[] crong4 = {111, 112};

        Problem4 sol = new Problem4();

        //when
        int answer1 = sol.solution(pobi1, crong1);
        int answer2 = sol.solution(pobi2, crong2);
        int answer3 = sol.solution(pobi3, crong3);

        //then
        assertThat(answer1).isEqualTo(0);
        assertThat(answer2).isEqualTo(1);
        assertThat(answer3).isEqualTo(-1);
    }
}
