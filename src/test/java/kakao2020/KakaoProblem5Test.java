package kakao2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KakaoProblem5Test {
    @DisplayName("카카오 5번 문제 ")
    @Test
    void test() {
        //given
        String play_time1 = "02:03:55";
        String adv_time1 = "00:14:15";
        String[] logs1 = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        String play_time2 = "99:59:59";
        String adv_time2 = "25:00:00";
        String[] logs2 = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};


        String play_time3 = "50:00:00";
        String adv_time3 = "50:00:00";
        String[] logs3 = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
        //when
        KakaoProblem5 sol = new KakaoProblem5();
        String answer1 = sol.solution(play_time1, adv_time1, logs1);
        String answer2 = sol.solution(play_time2, adv_time2, logs2);
        String answer3 = sol.solution(play_time3, adv_time3, logs3);

        //then
        assertThat(answer1).isEqualTo("01:30:59");
        assertThat(answer2).isEqualTo("01:00:00");
        assertThat(answer3).isEqualTo("00:00:00");
    }
}
