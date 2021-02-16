package wootech3rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WooProblem6Test {
    @Test
    void name() {
        //given
        String[] logs1 = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
        String[] logs2 = {"1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "2001 1 100", "2001 2 100", "2001 4 100", "2001 7 95", "2001 9 100", "2002 1 95", "2002 2 100", "2002 4 100", "2002 7 100", "2002 9 100"};
        String[] logs3 = {"1901 10 50", "1909 10 50"};

        //when
        WooProblem6 sol = new WooProblem6();
        String[] answer1 = sol.solution(logs1);
        String[] answer2 = sol.solution(logs2);
        String[] answer3 = sol.solution(logs3);

        //then
        assertThat(answer1).isEqualTo(new String[]{"0001", "0002"});
        assertThat(answer2).isEqualTo(new String[]{"1901", "1902", "1903"});
        assertThat(answer3).isEqualTo(new String[]{"None"});
    }
}
