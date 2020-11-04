package wootech1st20201101;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem5 {
    public int solution(int number) {
        return IntStream.rangeClosed(1, number)
                .map(this::isClapTiming)
                .sum();
    }

    private int isClapTiming(int number) {
        int[] numbers = Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::valueOf)
                .toArray();

        int cnt = 0;
        for (int num : numbers) {
            if (num == 3 || num == 6 || num == 9) {
                cnt++;
            }
        }

        return cnt;
    }
}
