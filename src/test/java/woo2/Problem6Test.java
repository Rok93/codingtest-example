package woo2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    @DisplayName("우테코 6번 문제를 풀이한다 ")
    @Test
    void testFunction() {
        //given
        String[][] forms = {{"jm@email.com", "제이엠"}, {"jason@email.com", "제이슨"}, {"woniee@email.com", "워니"}
                , {"mj@email.com", "엠제이"}, {"nowm@email.com", "이제엠"}};

        Problem6 sol = new Problem6();

        //when
        String[] answer = sol.solution(forms);

        //then
        assertThat(answer).isEqualTo(new String[]{"jason@email.com", "jm@email.com", "mj@email.com"});
    }
}
