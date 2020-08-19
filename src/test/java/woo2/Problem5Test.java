package woo2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {
    @DisplayName("우아한테크코스 2기 5번 문제 풀이를 테스트한다. ")
    @Test
    void testFunction() {
        //given
        String[] history1 = new String[]{"1.0", "2.0", "1.5"};
        String[] history2 = new String[]{"1.0", "2.0", "0.0", "1.0"};
        Problem5 sol = new Problem5();

        //when
        int[] answer1 = sol.solution(history1);
        int[] answer2 = sol.solution(history2);

        //then
        assertThat(answer1).isEqualTo(new int[]{3000, 14000, 15000});
        assertThat(answer2).isEqualTo(new int[]{-1});
    }

//    @DisplayName("히든 케이스에 대해서 풀이를 테스트 한다 ")
//    @Test
//    void testFunctionHiddenCase() {
//        String[][] inputs = {{"0.0"}, {"-1.0"}, {"0.5"}, {"1.2"}, {"3.0"}, {"1.0"}, {"1.5"}, {"2.0"}, {"1.0", "2.0", "1.0"}, {"1.0", "1.0", "2.0", "2.0"}, {"1.0", "1.0", "2.0", "2.0", "1.0", "1.0", "2.0", "2.0", "1.0", "2.0", "2.0", "2.0", "1.0", "2.0", "2.0", "1.0", "1.0", "1.0", "2.0", "2.0", "1.0", "2.0", "1.0", "2.0"}, {"1.5", "2.0", "1.0"}, {"1.5", "2.5", "1.0", "1.0"}, {"1.5", "2.5", "1.0", "2.5", "1.0"}, {"1.5", "2.5", "1.0", "-1.0"}, {"1.5", "0.5", "1.0", "2.0"}, {"1.5", "2.5", "1.0", "2.0", "1.2"}, {"1.5", "2.5", "1.0", "3.0", "1.5"}, {"1.5", "2.5", "1.0", "2.0", "1.5", "2.0", "2.0", "2.0", "1.5", "2.5", "1.0", "2.0", "1.5", "2.0", "2.0", "2.0", "1.5", "2.5", "1.0", "2.0", "1.5", "2.0", "2.0", "2.0"}, {"1.5", "2.5", "0.0", "1.0"}};
//        int[][] answers = {{-1}, {-1}, {-1}, {-1}, {-1}, {3000}, {14000}, {14000}, {3000, 14000, 11000}, {3000, 11000, 14000, 7000}, {3000, 11000, 14000, 7000, 13000, 1000, 14000, 17000, 3000, 15000, 17000, 14000, 1000, 16000, 15000, 3000, 4000, 13000, 15000, 6000, 11000, 14000, 4000, 16000}, {14000, 3000, 15000}, {14000, 13000, 4000, 3000}, {14000, 13000, 4000, 17000, 3000}, {-1}, {-1}, {-1}, {-1}, {14000, 13000, 4000, 16000, 5000, 14000, 16000, 15000, 2000, 18000, 11000, 16000, 4000, 14000, 17000, 15000, 3000, 16000, 11000, 7000, 14000, 14000, 17000, 4000}, {-1}};
//
//        assertThat(inputs.length).isEqualTo(answers.length);
//
//        Problem5 sol = new Problem5(); // 12, 13, 19 번째 케이
//        int length = inputs.length;
//        for (int i = 0; i < length; i++) {
//            assertThat(sol.solution(inputs[i])).isEqualTo(answers[i]);
//        }
//    }

    @DisplayName("효율적인 테스트 코드 작성..")
    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/test_case.txt"})
    void testFuntionHiddenCase2(File file) throws Exception {
        final List<String> testSet = extractTestSet(file, 1);
        for (final String row : testSet) {
            final String[] testCase = row.substring(1, row.length() - 1).split(",");
            System.out.println(Arrays.toString(testCase));
        }
    }

    private List<String> extractTestSet(final File file, final Integer number) throws Exception {
        final List<String> testSet = new ArrayList<>(2);
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        boolean find = false;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                find = false;
            }

            if (line.startsWith(String.format("%s.", number))) {
                find = true;
                continue;
            }

            if (find) {
                testSet.add(line);
            }
        }
        return testSet;
    }
}
