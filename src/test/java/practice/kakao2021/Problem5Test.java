package practice.kakao2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {

    @DisplayName("가사 검색 기능을 테스트한다.")
    @Test
    void test_Solution() {
        //given
        Problem5 sol = new Problem5();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        //when
        int[] answer = sol.solution(words, queries);

        //then
        assertThat(answer).isEqualTo(new int[]{3, 2, 4, 1, 0});
    }
}