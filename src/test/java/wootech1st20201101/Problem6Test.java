package wootech1st20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {
    @Test
    void name() {
        //given
        int totalTicket = 2000;
        String[] logs = {
                "woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02"
        };


        //when
        Problem6 sol = new Problem6();
        String[] answer = sol.solution(totalTicket, logs);

        //then
        assertThat(answer).isEqualTo(new String[]{"jason", "woni"});
    }
}
