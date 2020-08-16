package skillcheck.day1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    public void name() {
        Problem2 sol = new Problem2();
        int[] works = {4, 3, 3};
        int n = 4;

        int[] works2 = {2, 1, 2};
        int n2 = 1;

        int[] works3 = {1, 1};
        int n3 = 3;


        assertThat(12).isEqualTo(sol.solution(n, works));
        assertThat(6).isEqualTo(sol.solution(n2, works2));
        assertThat(0).isEqualTo(sol.solution(n3, works3));
    }
}