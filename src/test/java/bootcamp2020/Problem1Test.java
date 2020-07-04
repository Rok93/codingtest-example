package bootcamp2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
    @Test
    void testFunction() {
        //given
        String[] nameList1 = {"가을", "우주", "너굴"};
        String[] nameList2 = {"봄", "여울", "봄봄"};
        String[] nameList3 = {"너굴", "너울", "여울", "서울"};
        Problem1 sol = new Problem1();

        //when
        boolean answer1 = sol.solution(nameList1);
        boolean answer2 = sol.solution(nameList2);
        boolean answer3 = sol.solution(nameList3);

        //then
        assertThat(answer1).isFalse();
        assertThat(answer2).isTrue();
        assertThat(answer3).isFalse();
    }
}
