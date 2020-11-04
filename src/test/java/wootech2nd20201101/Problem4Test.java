package wootech2nd20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @Test
    void name() {
        //given
        String[] infos = {"kim password", "lee abc"};

        String[] actions = {"ADD 30",
                "LOGIN kim abc",
                "LOGIN lee password",
                "LOGIN kim password",
                "LOGIN kim password",
                "ADD 30",
                "ORDER",
                "ORDER",
                "ADD 40",
                "ADD 50"};
        //when
        Problem4 sol = new Problem4();
        boolean[] answer = sol.solution(infos, actions);

        //then
        assertThat(answer).isEqualTo(new boolean[]{false, false, false, true, false, true, true, false, true, true});
    }
}
