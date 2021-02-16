package est_vanillaproject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {

    @DisplayName("1번문제 예제테스트")
    @Test
    void name() {
        //given
        String[] card_num = {"3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"};

        //when
        Problem1 sol = new Problem1();
        int[] answer = sol.solution(card_num);

        //then
        assertThat(answer).isEqualTo(new int[]{1, 1, 0, 0, 0, 0});
    }
}
