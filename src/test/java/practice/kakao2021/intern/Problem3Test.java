package practice.kakao2021.intern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @DisplayName("불량 사용자 기능을 테스트한다")
    @Test
    void test_Solution() {
        //given
        Problem3 sol = new Problem3();
        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id1 = {"fr*d*", "abc1**"};
        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id2 = {"*rodo", "*rodo", "******"};
        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};


        //when
        int answer1 = sol.solution(user_id1, banned_id1);
        int answer2 = sol.solution(user_id2, banned_id2);
        int answer3 = sol.solution(user_id3, banned_id3);

        //then
        assertThat(answer1).isEqualTo(2);
        assertThat(answer2).isEqualTo(2);
        assertThat(answer3).isEqualTo(3);

    }
}