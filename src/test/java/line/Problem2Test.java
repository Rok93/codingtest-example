package line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class Problem2Test {

    Problem2 sol = new Problem2();

    @Test
    public void 문제2를_테스트하다() {
        String answer_sheet1 = "4132315142";
        String[] sheets1 = {"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"};

        String answer_sheet2 = "53241";
        String[] sheets2 = {"53241", "42133", "53241", "14354"};

        String answer_sheet3 = "24551";
        String[] sheets3 = {"24553", "24553", "24553", "24553"};

        assertThat(17).isEqualTo(sol.solution(answer_sheet1, sheets1));
        assertThat(0).isEqualTo(sol.solution(answer_sheet2, sheets2));
        assertThat(2).isEqualTo(sol.solution(answer_sheet3, sheets3));
    }
}