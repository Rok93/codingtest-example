package gamadevmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @DisplayName("게임 개발자 매칭 1번문제 풀이를 테스트한다 ")
    @Test
    void testFunction() {
        //given
        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        //when
        Problem1 sol = new Problem1();
        int answer1 = sol.solution(word1);
        int answer2 = sol.solution(word2);
        int answer3 = sol.solution(word3);
        int answer4 = sol.solution(word4);

        //then
        assertThat(answer1).isEqualTo(6);
        assertThat(answer2).isEqualTo(10);
        assertThat(answer3).isEqualTo(1563);
        assertThat(answer4).isEqualTo(1189);

    }
}
