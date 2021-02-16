package wootech3rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WooProblem5Test {
    @Test
    void name() {
        //given
        String penter1 = "1100";
        String penter2 = "10";

        String pexit1 = "0010";
        String pexit2 = "11";

        String pescape1 = "1001";
        String pescape2 = "00";

        String data1 = "1101100100101111001111000000";
        String data2 = "00011011";

        //when
        WooProblem5 sol = new WooProblem5();
        String answer1 = sol.solution(penter1, pexit1, pescape1, data1);
        String answer2 = sol.solution(penter2, pexit2, pescape2, data2);

        //then
        assertThat(answer1).isEqualTo("110011011001100110010010111100111001110000000010");
        assertThat(answer2).isEqualTo("100000010010001111");
    }
}
