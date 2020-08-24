package p20200823.socar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SocarProblem1Test {
    @DisplayName("쏘카 1번 문제 풀이 ")
    @Test
    void testFunction() {
        //given
        String[] bakery_schedule1 = {"09:05 10", "12:20 5", "13:25 6", "14:24 5"};
        String[] bakery_schedule2 = {"12:00 10"};
        String[] bakery_schedule3 = {"12:00 10"};

        String current_time1 = "12:05";
        String current_time2 = "12:00";
        String current_time3 = "12:00";

        int K1 = 10;
        int K2 = 10;
        int K3 = 11;


        //when
        SocarProblem1 sol = new SocarProblem1();
        int answer1 = sol.solution(bakery_schedule1, current_time1, K1);
        int answer2 = sol.solution(bakery_schedule2, current_time2, K2);
        int answer3 = sol.solution(bakery_schedule3, current_time3, K3);

        //then
        assertThat(answer1).isEqualTo(80);
        assertThat(answer2).isEqualTo(0);
        assertThat(answer3).isEqualTo(-1);
    }
}
