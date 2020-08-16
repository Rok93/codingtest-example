package line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    Problem5 sol = new Problem5();

    @Test
    public void 테스트한다() {
        String[][] dataSource = {
                {"doc1", "t1", "t2", "t3"},
                {"doc2", "t0", "t2", "t3"},
                {"doc3", "t1", "t6", "t7"},
                {"doc4", "t1", "t2", "t4"},
                {"doc5", "t6", "t100", "t8"}
        };

        String[][] dataSource2 = {
                {"doc1", "t1", "t2", "t3"},
                {"doc2", "t0", "t2", "t3"},
                {"doc3", "t1", "t6", "t7"},
                {"doc4", "t1", "t2", "t4"},
                {"doc6", "t6", "t100", "t3"},
                {"doc5", "t6", "t100", "t3"},
        };

        String[] tags = {"t1", "t2", "t3"};
        String[] result1 = {"doc1", "doc2", "doc4", "doc3"};
        assertThat(result1).isEqualTo(sol.solution(dataSource, tags));

        String[] result2 = {"doc1", "doc2", "doc4", "doc3", "doc5","doc6"};
        assertThat(result2).isEqualTo(sol.solution(dataSource2, tags));
    }
}