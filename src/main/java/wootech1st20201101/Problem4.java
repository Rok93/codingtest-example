package wootech1st20201101;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem4 {
    private static final int NOT_CORRECT_INFO = -1;

    public int solution(int[] pobi, int[] crong) {
        if (!isCorrectValues(pobi) || !isCorrectValues(crong)) {
            return NOT_CORRECT_INFO;
        }

        int pobiMaxValue = getMaxValue(pobi);
        int crongMaxValue = getMaxValue(crong);

        if (pobiMaxValue > crongMaxValue) {
            return 1; // 포비 승리
        }

        if (pobiMaxValue < crongMaxValue) {
            return 2; // crong 승리
        }

        return 0; // 무승부
    }

    private int getMaxValue(int[] pages) {
        String word = Arrays.stream(pages)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        int[] numbers = Arrays.stream(word.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Arrays.stream(numbers)
                .sum();

        int multipleValue = Arrays.stream(numbers)
                .reduce(1, (a, b) -> a * b);

        return Math.max(sum, multipleValue);
    }

    private boolean isCorrectValues(int[] pages) {
        if (pages[0] % 2 == 0 || pages[1] % 2 == 1) {
            return false;
        }

        if (pages[1] - pages[0] != 1) {
            return false;
        }

        return true;
    }
}
