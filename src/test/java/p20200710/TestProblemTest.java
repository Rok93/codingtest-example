package p20200710;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TestProblemTest {

    @Test
    void testProblem() {
        //given
        int n = 15;
        TestProblem sol = new TestProblem();

        //when
        int solution = sol.solution(n);

        //then
        assertThat(solution).isEqualTo(4);
    }
}
