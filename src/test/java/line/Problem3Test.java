package line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    Problem3 sol = new Problem3();

    @Test
    public void 테스트3을_테스트하다() {
        String road1 = "111011110011111011111100011111";
        int n1 = 3;
        assertThat(18).isEqualTo(sol.solution(road1, n1));

        String road2 = "001100";
        int n2 = 5;
        assertThat(6).isEqualTo(sol.solution(road2, n2));


    }
}