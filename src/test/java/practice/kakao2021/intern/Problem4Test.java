package practice.kakao2021.intern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {

    @DisplayName("호텔 방 배정 기능을 테스트한다")
    @Test
    void test_Solution() {
        //given
        Problem4 sol = new Problem4();
        int k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};

        //when
        long[] answer = sol.solution2(k, room_number);

        //then
        assertThat(answer).isEqualTo(new long[]{1, 3, 4, 2, 5, 6});
    }
}