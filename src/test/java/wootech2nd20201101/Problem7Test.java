package wootech2nd20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem7Test {
    @Test
    void name() {
        //given
        String user = "mrko";
        String[][] friends = {
                {"donut", "andole"}, {"donut", "jun"}, {"donut", "mrko"}, {"shakevan", "andole"}, {"shakevan", "jun"}, {"shakevan", "mrko"}
        };
        String[] visitors = {"bedi", "bedi", "donut", "bedi", "shakevan"};

        //when
        Problem7 sol = new Problem7();
        String[] answer = sol.solution(user, friends, visitors);

        //then
        assertThat(answer).isEqualTo(new String[]{"andole", "bedi", "jun"});
    }
}
