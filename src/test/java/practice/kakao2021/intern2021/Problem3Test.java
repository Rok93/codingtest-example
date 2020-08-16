package practice.kakao2021.intern2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @DisplayName("3번문제를 테스트한다.")
    @Test
    void test_Solution() {
        //given
        Problem3 sol = new Problem3();
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        //when
        int[] answer1 = sol.solution(gems1);
        int[] answer2 = sol.solution(gems2);
        int[] answer3 = sol.solution(gems3);
        int[] answer4 = sol.solution(gems4);

        //then
        assertThat(answer1).isEqualTo(new int[]{3,7});
        assertThat(answer2).isEqualTo(new int[]{1,3});
        assertThat(answer3).isEqualTo(new int[]{1,1});
        assertThat(answer4).isEqualTo(new int[]{1,5});
    }
}