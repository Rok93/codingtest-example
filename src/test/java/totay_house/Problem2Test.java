package totay_house;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Problem2Test {

    @ParameterizedTest
    @MethodSource
    void solution(int personNumber, List<Integer> runtimes, int output) {
        //given

        //when
        Problem2 sol = new Problem2();
        int actual = sol.solution(personNumber, runtimes);

        //then
        assertThat(actual).isEqualTo(output);
    }

    private static Stream<Arguments> solution() {
        return Stream.of(
            Arguments.of(4, Arrays.asList(1, 2, 5, 10), 17),
            Arguments.of(7, Arrays.asList(10, 20, 30, 40, 50, 60, 70), 280)
        );
    }
}
