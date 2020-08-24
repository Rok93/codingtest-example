package p20200823.socar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SocarProblem2Test {
    @DisplayName("쏘카 2번문제 풀이 ")
    @Test
    void testFunction() {
        //given
        String[] drum = {"######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"};

        //when
        SocarProblem2 sol = new SocarProblem2();
        int answer = sol.solution(drum);

        //then
        assertThat(answer).isEqualTo(4);
    }
}
