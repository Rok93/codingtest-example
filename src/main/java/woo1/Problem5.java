package woo1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem5 {
    public int solution(int number) {
        return IntStream.rangeClosed(1, number)
                .boxed()
                .mapToInt(this::countClap)
                .sum();
    }

    private int countClap(int number) {
        return (int) Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .filter(this::isEqulToThreeOrSixOrNine)
                .count();
    }

    private boolean isEqulToThreeOrSixOrNine(int number) {
        return number == 3 || number == 6 || number == 9;
    }
}
