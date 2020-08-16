package practice.kakao2021.intern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    @DisplayName("튜플 기능을 테스트한다")
    @Test
    void test_Solution() {
        //given
        Problem2 sol = new Problem2();
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        //when
        int[] answer1 = sol.solution(s1);
        int[] answer2 = sol.solution(s2);
        int[] answer3 = sol.solution(s3);
        int[] answer4 = sol.solution(s4);
        int[] answer5 = sol.solution(s5);

        //then
        assertThat(answer1).isEqualTo(new int[]{2, 1, 3, 4});
        assertThat(answer2).isEqualTo(new int[]{2, 1, 3, 4});
        assertThat(answer3).isEqualTo(new int[]{111, 20});
        assertThat(answer4).isEqualTo(new int[]{123});
        assertThat(answer5).isEqualTo(new int[]{3, 2, 4, 1});
    }
}