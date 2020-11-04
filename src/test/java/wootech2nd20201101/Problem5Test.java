package wootech2nd20201101;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {
    @Test
    void name() {
        //given
        String[] history1 = {"1.0", "2.0", "1.5"};
        String[] history2 = {"1.0", "2.0", "0.0", "1.5"};
        String[] history3 = {"0.0"};
        String[] history4 = {"-1.0"};
        String[] history5 = {"0.5"};
        String[] history6 = {"1.2"};
        String[] history7 = {"3.0"};
        String[] history8 = {"1.0"};
        String[] history9 = {"1.5"};
        String[] history10 = {"2.0"};
        String[] history11 = {"1.0", "2.0", "1.0"};
        String[] history12 = {"1.0", "1.0", "2.0", "2.0"};
        String[] history13 = {"1.0", "1.0", "2.0", "2.0", "1.0", "1.0", "2.0", "2.0", "1.0", "2.0", "2.0", "2.0", "1.0", "2.0", "2.0", "1.0", "1.0", "1.0", "2.0", "2.0", "1.0", "2.0", "1.0", "2.0"};
        String[] history14 = {"1.5", "2.0", "1.0"};
        String[] history15 = {"1.5", "2.5", "1.0", "1.0"};
        String[] history16 = {"1.5", "2.5", "1.0", "2.5", "1.0"}; //14
        String[] history17 = {"1.5", "2.5", "1.0", "-1.0"};
        String[] history18 = {"1.5", "0.5", "1.0", "2.0"};
        String[] history19 = {"1.5", "2.5", "1.0", "2.0", "1.2"};
        String[] history20 = {"1.5", "2.5", "1.0", "3.0", "1.5"};
        String[] history21 = {"1.5", "2.5", "1.0", "2.0", "1.5", "2.0", "2.0", "2.0", "1.5", "2.5", "1.0", "2.0", "1.5", "2.0", "2.0", "2.0", "1.5", "2.5", "1.0", "2.0", "1.5", "2.0", "2.0", "2.0"};
        String[] history22 = {"1.5", "2.5", "0.0", "1.0"};

        //when
        Problem5 sol = new Problem5();
        int[] answer1 = sol.solution(history1);
        int[] answer2 = sol.solution(history2);
        int[] answer3 = sol.solution(history3);
        int[] answer4 = sol.solution(history4);
        int[] answer5 = sol.solution(history5);
        int[] answer6 = sol.solution(history6);
        int[] answer7 = sol.solution(history7);
        int[] answer8 = sol.solution(history8);
        int[] answer9 = sol.solution(history9);
        int[] answer10 = sol.solution(history10);
        int[] answer11 = sol.solution(history11);
        int[] answer12 = sol.solution(history12);
        int[] answer13 = sol.solution(history13);
        int[] answer14 = sol.solution(history14);
        int[] answer15 = sol.solution(history15);
        int[] answer16 = sol.solution(history16);
        int[] answer17 = sol.solution(history17);
        int[] answer18 = sol.solution(history18);
        int[] answer19 = sol.solution(history19);
        int[] answer20 = sol.solution(history20);
        int[] answer21 = sol.solution(history21);
        int[] answer22 = sol.solution(history22);

        //then
        assertThat(answer1).isEqualTo(new int[] {3000, 14000, 15000});
        assertThat(answer2).isEqualTo(new int[] {-1});
        assertThat(answer3).isEqualTo(new int[] {-1});
        assertThat(answer4).isEqualTo(new int[] {-1});
        assertThat(answer5).isEqualTo(new int[] {-1});
        assertThat(answer6).isEqualTo(new int[] {-1});
        assertThat(answer7).isEqualTo(new int[] {-1});
        assertThat(answer8).isEqualTo(new int[] {3000});
        assertThat(answer9).isEqualTo(new int[] {14000});
        assertThat(answer10).isEqualTo(new int[] {14000});
        assertThat(answer11).isEqualTo(new int[] {3000, 14000, 11000});
        assertThat(answer12).isEqualTo(new int[] {3000, 11000, 14000, 7000});
        assertThat(answer13).isEqualTo(new int[] {3000, 11000, 14000, 7000, 13000, 1000, 14000, 17000, 3000, 15000, 17000, 14000, 1000, 16000, 15000, 3000, 4000, 13000, 15000, 6000, 11000, 14000, 4000, 16000});
        assertThat(answer14).isEqualTo(new int[]{14000, 3000, 15000});
        assertThat(answer15).isEqualTo(new int[]{14000, 13000, 4000, 3000});
        assertThat(answer16).isEqualTo(new int[]{14000, 13000, 4000, 17000, 3000});
        assertThat(answer17).isEqualTo(new int[]{-1});
        assertThat(answer18).isEqualTo(new int[]{-1});
        assertThat(answer19).isEqualTo(new int[]{-1});
        assertThat(answer20).isEqualTo(new int[]{-1});
        assertThat(answer21).isEqualTo(new int[]{14000, 13000, 4000, 16000, 5000, 14000, 16000, 15000, 2000, 18000, 11000, 16000, 4000, 14000, 17000, 15000, 3000, 16000, 11000, 7000, 14000, 14000, 17000, 4000});
        assertThat(answer22).isEqualTo(new int[]{-1});

    }
}
