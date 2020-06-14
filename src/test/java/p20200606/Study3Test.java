package p20200606;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Study3Test {
    @Test
    void testCode() {
        //given
        Study3 sol = new Study3();
        String command1 = "<v>AB^CYv^XAZ";
        String command2 = "ABCXYZ";
        String command3 = "ABCXYZ";
        String command4 = "<v>AB^CYv^XAZv>AB^CYv^XA";
        String[] buttons1 = {"v>AB^CYv^XA", "<v>A", "^XAZ", "Yv^XA", ">AB^"};
        String[] buttons2 = {"BCXY"};
        String[] buttons3 = {"CXYZ", "AB"};
        String[] buttons4 = {"v>AB^CYv^XA", "<v>A", "^XAZ", "Yv^XA", ">AB^"};
        int[] scores1 = {50, 18, 20, 30, 25};
        int[] scores2 = {2};
        int[] scores3 = {2, 3};
        int[] scores4 = {50, 18, 20, 30, 25};

        //when
        int answer1 = sol.solution(command1,buttons1,scores1);
        int answer2 = sol.solution(command2,buttons2,scores2);
        int answer3 = sol.solution(command3,buttons3,scores3);
//        int answer4 = sol.solution(command4,buttons4,scores4);


        //then
        assertThat(answer1).isEqualTo(59);
        assertThat(answer2).isEqualTo(6);
        assertThat(answer3).isEqualTo(7);
//        assertThat(answer4).isEqualTo(102);
    }
}
