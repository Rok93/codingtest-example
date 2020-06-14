package p20200606;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Study1Test {

    @Test
    void testCode() {
        //given
        Study1 sol = new Study1();
        String[] moves1 = {"U", "R", "D", "L", "U", "R", "D", "L"};
        String[] moves2 = {"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"};
        String[] moves3 = {"U", "L", "D", "R", "R", "D", "D", "L", "U", "U"};

        //when
        int answer1 = sol.solution(moves1);
        int answer2 = sol.solution(moves2);
        int answer3 = sol.solution(moves3);

        //then
        assertThat(answer1).isEqualTo(1);
        assertThat(answer2).isEqualTo(5);
        assertThat(answer3).isEqualTo(1);
    }
}
