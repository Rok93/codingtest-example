package woo2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Woo5Test {

    @ParameterizedTest
    @ValueSource(strings = {
             "[\"0.0\"]", "[\"-1.0\"]", "[\"0.5\"]", "[\"1.2\"]", "[\"3.0\"]", "[\"1.0\"]", "[\"1.5\"]",
             "[\"2.0\"]", "[\"1.0\", \"2.0\", \"1.0\"]", "[\"1.0\", \"1.0\", \"2.0\", \"2.0\"]",
            "[\"1.0\", \"1.0\", \"2.0\", \"2.0\", \"1.0\", \"1.0\", \"2.0\", \"2.0\", \"1.0\", \"2.0\", \"2.0\", \"2.0\", \"1.0\", \"2.0\", \"2.0\", \"1.0\", \"1.0\", \"1.0\", \"2.0\", \"2.0\", \"1.0\", \"2.0\", \"1.0\", \"2.0\"]",
             "[\"1.5\", \"2.0\", \"1.0\"]", "[\"1.5\", \"2.5\", \"1.0\", \"1.0\"]",
             "[\"1.5\", \"2.5\", \"1.0\", \"2.5\", \"1.0\"]", "[\"1.5\", \"2.5\", \"1.0\", \"-1.0\"]",
             "[\"1.5\", \"0.5\", \"1.0\", \"2.0\"]", "[\"1.5\", \"2.5\", \"1.0\", \"2.0\", \"1.2\"]",
             "[[\"1.5\", \"2.5\", \"1.0\", \"3.0\", \"1.5\"]]",
            "[\"1.5\", \"2.5\", \"1.0\", \"2.0\", \"1.5\", \"2.0\", \"2.0\", \"2.0\", \"1.5\", \"2.5\", \"1.0\", \"2.0\", \"1.5\", \"2.0\", \"2.0\", \"2.0\", \"1.5\", \"2.5\", \"1.0\", \"2.0\", \"1.5\", \"2.0\", \"2.0\", \"2.0\"]",
             "[\"1.5\", \"2.5\", \"0.0\", \"1.0\"]"
    })
    public void test(String input) {
        Woo5 woo5 = new Woo5();
        String[] testHistory = input.replaceAll("\\[", "").replaceAll("]", "").split(",");
        int[] testAnswer = woo5.solution(testHistory);
        String answer = Arrays.stream(testAnswer)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(answer);
//        try {
            String[] testAnswerString = new String[]{
                     "[-1]", "[-1]", "[-1]", "[-1]", "[-1]", "[3000]", "[14000]",
                     "[14000]", "[3000, 14000, 11000]", "[3000, 11000, 14000, 7000]",
                    "[3000, 11000, 14000, 7000, 13000, 1000, 14000, 17000, 3000, 15000, 17000, 14000, 1000, 16000, 15000, 3000, 4000, 13000, 15000, 6000, 11000, 14000, 4000, 16000]",
                     "[14000, 3000, 15000]", "[14000, 13000, 4000, 3000]", "[14000, 13000, 4000, 17000, 3000]",
                     "[-1]", "[-1]", "[-1]", "[-1]",
                    "[14000, 13000, 4000, 16000, 5000, 14000, 16000, 15000, 2000, 18000, 11000, 16000, 4000, 14000, 17000, 15000, 3000, 16000, 11000, 7000, 14000, 14000, 17000, 4000]",
                     "[-1]"
            };

            for (int j = 0; j < testHistory.length; j++) {
                System.out.println((j + 1) + "번 반복!");
//                int[] answer = new int[testAnswer.length];
////                System.out.println(testAnswerString[j]);
//
                String currentAnswer = testAnswerString[j].replaceAll("\\[", "")
                        .replaceAll("\\]", "");

                int[] testAnswers = Arrays.stream(currentAnswer.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();
//
//                assertThat(testAnswer).isEqualTo(testAnswers);
//                Assertions.assertArrayEquals(testAnswer, testAnswers);
            }
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
    }
}
