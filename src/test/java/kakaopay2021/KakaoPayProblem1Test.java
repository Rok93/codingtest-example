package kakaopay2021;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class KakaoPayProblem1Test {

    @Test
    void test1() {
        //given
        int money1 = 12345678;
        int minratio1 = 10;
        int maxratio1 = 20;
        int ranksize1 = 250000;
        int threshold1 = 10_000_000;
        int months1 = 4;
        int answer1 = 9000014;

        int money2 = 1_000_000_000;
        int minratio2 = 50;
        int maxratio2 = 99;
        int ranksize2 = 100000;
        int threshold2 = 0;
        int months2 = 6;
        int answer2 = 6150;

        int money3 = 123456789;
        int minratio3 = 0;
        int maxratio3 = 0;
        int ranksize3 = 1;
        int threshold3 = 0;
        int months3 = 360;
        int answer3 = 123456789;

        //when
        KakaoPayProblem1 kakaoPayProblem1 = new KakaoPayProblem1();
        int actual1 = kakaoPayProblem1
            .solution(money1, minratio1, maxratio1, ranksize1, threshold1, months1);
        int actual2 = kakaoPayProblem1
            .solution(money2, minratio2, maxratio2, ranksize2, threshold2, months2);
        int actual3 = kakaoPayProblem1
            .solution(money3, minratio3, maxratio3, ranksize3, threshold3, months3);

        //then
        assertThat(actual1).isEqualTo(answer1);
        assertThat(actual2).isEqualTo(answer2);
        assertThat(actual3).isEqualTo(answer3);
    }
}
