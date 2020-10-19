package naver2021;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NaverProblem3Test {

    @DisplayName("네이버 3번 문제 ")
    @Test
    void name() {
        //given
        int n1 = 19;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}, {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}};

        int n2 = 14;
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 8}, {3, 9}, {3, 10}, {4, 11}, {4, 12}, {4, 13}};

        int n3 = 10;
        int[][] edges3 = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}};

        //when
        NaverProblem3 sol = new NaverProblem3();
        int answer1 = sol.solution(n1, edges1);
        int answer2 = sol.solution(n2, edges2);
        int answer3 = sol.solution(n3, edges3);

        //then
        assertThat(answer1).isEqualTo(7);
        assertThat(answer2).isEqualTo(4);
        assertThat(answer3).isEqualTo(2);
    }
}
