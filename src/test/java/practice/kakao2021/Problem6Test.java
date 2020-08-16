package practice.kakao2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    @DisplayName("기둥과 보 설치 기능을 테스트한다")
    @Test
    void test_Solution() {
        //given
        Problem6 sol = new Problem6();
        int n1 = 5;
        int n2 = 5;
        int[][] build_frame1 = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] build_frame2 = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

        //when
        int[][] answer1 = sol.solution(n1, build_frame1);
        int[][] answer2 = sol.solution(n2, build_frame2);

        //then
        assertThat(answer1).isEqualTo(new int[][]{
                {1, 0, 0}, {1, 1, 1}, {2, 1, 0}, {2, 2, 1}, {3, 2, 1}, {4, 2, 1}, {5, 0, 0}, {5, 1, 0}
        });

        assertThat(answer2).isEqualTo(new int[][]{
                {0, 0, 0}, {0, 1, 1}, {1, 1, 1}, {2, 1, 1}, {3, 1, 1}, {4, 0, 0}
        });

    }
}