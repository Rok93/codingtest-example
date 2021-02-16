package wootech3rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WooProblem3Test {
    @Test
    void name() {
        //given
        int money1 = 1000;
        int money2 = 1200;
        int money3 = 1500;

        String[] expected1 = {"H", "T", "H", "T", "H", "T", "H"};
        String[] expected2 = {"T", "T", "H", "H", "H"};
        String[] expected3 = {"H", "H", "H", "T", "H"};

        String[] actual1 = {"T", "T", "H", "H", "T", "T", "H"};
        String[] actual2 = {"H", "H", "T", "H", "T"};
        String[] actual3 = {"T", "T", "T", "H", "T"};

        //when
        WooProblem3 sol = new WooProblem3();
        int answer1 = sol.solution(money1, expected1, actual1);
        int answer2 = sol.solution(money2, expected2, actual2);
        int answer3 = sol.solution(money3, expected3, actual3);

        //then
        assertThat(answer1).isEqualTo(1400);
        assertThat(answer2).isEqualTo(900);
        assertThat(answer3).isEqualTo(0);
    }
}
