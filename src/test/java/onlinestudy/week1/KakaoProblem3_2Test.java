package onlinestudy.week1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem3_2Test {
    @Test
    void testFunction() {
        //given
        int n1 = 5;
        int[][] build_frame1 = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {
                4, 2, 1, 1}, {3, 2, 1, 1}};

        int n2 = 5;
        int[][] build_frame2 = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

        //when
        KakaoProblem3_2 sol = new KakaoProblem3_2();
        int[][] answer1 = sol.solution(n1, build_frame1);
        int[][] answer2 = sol.solution(n2, build_frame2);

        //then
        assertThat(answer1).isEqualTo(new int[][]{{1, 0, 0}, {1, 1, 1}, {2, 1, 0}, {2, 2, 1}, {3, 2, 1}, {4, 2, 1}, {5, 0, 0}, {5, 1, 0}});
        assertThat(answer2).isEqualTo(new int[][]{{0, 0, 0}, {0, 1, 1}, {1, 1, 1}, {2, 1, 1}, {3, 1, 1}, {4, 0, 0}});
    }
}
