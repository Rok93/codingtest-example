package p20200523;

import java.util.Arrays;

public class Problem1 {
    public int solution(int p) {
        while (true) {
            if (isBeautifulYear(++p)) {
                return p;
            }
        }
    }

    private boolean isBeautifulYear(int year) {
        String stringYear = String.valueOf(year);
        String[] splitYear = stringYear.split("");
        int distinctSplitYear = (int) Arrays.stream(splitYear)
                .distinct()
                .count();
        return distinctSplitYear == stringYear.length();
    }
}
