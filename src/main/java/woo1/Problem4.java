package woo1;

import java.util.Arrays;

public class Problem4 {

    public static final int NEXT_PAGE_STATUS = 1;
    public static final int EXCEPTION_CASE = -1;
    public static final int POBI_WIN = 1;
    public static final int DRAW = 0;
    public static final int CRONG_WIN = 2;

    public int solution(int[] pobi, int[] crong) { //포비 승 : 1, 크롱 승 : 2, 무승부 : 0, 예외사항: -1
        int pobiMaxNumber = calculateMaxNumber(pobi);
        int crongMaxNumber = calculateMaxNumber(crong);

        if (pobiMaxNumber == EXCEPTION_CASE || crongMaxNumber == EXCEPTION_CASE) {
            return EXCEPTION_CASE;
        }

        return pobiMaxNumber > crongMaxNumber ? POBI_WIN : pobiMaxNumber == crongMaxNumber ? DRAW : CRONG_WIN;
    }

    private int calculateMaxNumber(int[] pages) {
        if (isNotValidatePages(pages)) {
            return EXCEPTION_CASE;
        }

        if (isNotValidateEachPage(pages)) {
            return EXCEPTION_CASE;
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < pages.length; i++) {
            int currentSum = sumEachNumber(pages[i]);
            maxValue = maxValue < currentSum ? currentSum : maxValue;
        }

        for (int i = 0; i < pages.length; i++) {
            int currentMultiple = multipleEachNumber(pages[i]);
            maxValue = maxValue < currentMultiple ? currentMultiple : maxValue;
        }

        return maxValue;
    }

    private boolean isNotValidateEachPage(int[] pages) {
        return isNotOdd(pages[0]) || isNotEven(pages[1]);
    }

    private boolean isNotOdd(int page) {
        return page % 2 != 1;
    }

    private boolean isNotEven(int page) {
        return page % 2 != 0;
    }


    private int multipleEachNumber(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
    }

    private int sumEachNumber(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isNotValidatePages(int[] pages) {
        return pages[1] - pages[0] != NEXT_PAGE_STATUS;
    }
}
