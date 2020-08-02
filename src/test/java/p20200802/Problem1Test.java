package p20200802;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @DisplayName("베스트 앨범 문제를 풀이한다 ")
    @Test
    void testFunction() {
        //given
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plats = {500, 600, 150, 800, 2500};
        Problem1 sol = new Problem1();

        //when
        int[] answer = sol.solution(genres, plats);

        //then
        assertThat(answer).isEqualTo(new int[]{4, 1, 3, 0});
    }
}
