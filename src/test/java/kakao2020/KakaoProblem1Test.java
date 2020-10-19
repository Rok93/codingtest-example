package kakao2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KakaoProblem1Test {
    @Test
    void testFunction() {
        //given
        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";

        //when
        KakaoProblem1 sol = new KakaoProblem1();
        String answer1 = sol.solution(new_id1);
        String answer2 = sol.solution(new_id2);
        String answer3 = sol.solution(new_id3);
        String answer4 = sol.solution(new_id4);
        String answer5 = sol.solution(new_id5);

        //then
        assertThat(answer1).isEqualTo("bat.y.abcdefghi");
        assertThat(answer2).isEqualTo("z--");
        assertThat(answer3).isEqualTo("aaa");
        assertThat(answer4).isEqualTo("123_.def");
        assertThat(answer5).isEqualTo("abcdefghijklmn");
    }
}
