package totay_house;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class Problem1Test {

    @ParameterizedTest
    @CsvSource(value = {
        "a1a2a1a1:a5", "a2c9b3c2:a2c11b3", "a3c11d1c3d3:a3c14d4", "a0b1c2b3:a0b4c2"
    }, delimiter = ':')
    void testProblem(String input, String output) {
        //given

        //when
        Problem1 sol = new Problem1();
        String actual = sol.solution(input);

        //then
        assertThat(actual).isEqualTo(output);
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(chars = {
        'a','b','c','A','B','C'
    })
    void name(char input) {
        //given

        //when
        boolean actual = Character.isLetter(input);

        //then
        assertThat(actual).isTrue();
    }
}
