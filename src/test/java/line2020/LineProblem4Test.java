package line2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineProblem4Test {
    @DisplayName("라인 4번 문제 풀이 ")
    @Test
    void testFunction() {
        //given
        int[][] maze1 = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
        int[][] maze2 = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
        int[][] maze3 = {{0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}};
        int[][] maze4 = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}};

        //when
        LineProblem4 sol = new LineProblem4();
        int answer1 = sol.solution(maze1);
        int answer2 = sol.solution(maze2);
        int answer3 = sol.solution(maze3);
        int answer4 = sol.solution(maze4);

        //then
        assertThat(answer1).isEqualTo(10);
        assertThat(answer2).isEqualTo(32);
        assertThat(answer3).isEqualTo(24);
        assertThat(answer4).isEqualTo(22);
    }
}
