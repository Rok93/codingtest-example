package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.kakao2021.Problem1;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2Test {

    private final Problem2 sol = new Problem2();

    @DisplayName("예제들을 테스트한다")
    @Test
    public void testFindPirmeNumber() {
        //given
        int n1 = 10;
        int n2 = 5;

        //when
        int answer1 = sol.solution(n1);
        int answer2 = sol.solution(n2);

        //then
        assertThat(answer1).isEqualTo(4);
        assertThat(answer2).isEqualTo(3);

    }
}