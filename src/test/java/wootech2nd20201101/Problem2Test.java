package wootech2nd20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    @Test
    void name() {
        //given
        String logs = "2019/05/01 00:59:19\n" +
                "2019/06/01 01:35:20\n" +
                "2019/08/01 02:01:22\n" +
                "2019/08/01 02:01:23\n" +
                "2019/08/02 03:02:35\n" +
                "2019/10/03 04:05:40\n" +
                "2019/10/04 06:23:10\n" +
                "2019/10/10 08:23:20\n" +
                "2019/10/12 08:42:24\n" +
                "2019/10/23 08:43:26\n" +
                "2019/11/14 08:43:29\n" +
                "2019/11/01 10:19:02\n" +
                "2019/12/01 11:23:10";

        //when
        Problem2 sol = new Problem2();
        int[] answer = sol.solution(logs);

        //then
        assertThat(answer).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 1, 1, 0, 1, 0, 4, 0, 1, 1, 0, 0, 0});
    }
}
