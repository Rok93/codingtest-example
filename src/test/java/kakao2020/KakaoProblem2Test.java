package kakao2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KakaoProblem2Test {
    @DisplayName("카카오 2번 문제 !")
    @Test
    void testFunction() {
        //given
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] orders3 = {"XYZ", "XWY", "WXA"};

        int[] course1 = {2,3,4};
        int[] course2 = {2,3,5};
        int[] course3 = {2,3,4};

        //when
        KakaoProblem2 sol = new KakaoProblem2();
        String[] answer1 = sol.solution(orders1, course1);
        String[] answer2 = sol.solution(orders2, course2);
        String[] answer3 = sol.solution(orders3, course3);

        //then
        assertThat(answer1).isEqualTo(new String[] {"AC", "ACDE", "BCFG", "CDE"});
        assertThat(answer2).isEqualTo(new String[] {"ACD", "AD", "ADE", "CD", "XYZ"});
        assertThat(answer3).isEqualTo(new String[] {"WX", "XY"});
    }
}
