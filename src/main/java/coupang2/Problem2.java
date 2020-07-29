package coupang2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2 {
    public int solution(int p) {

        int answer = IntStream.iterate(p + 1, n -> n + 1)
                .filter(year -> isBeautifulYear(year))
                .findFirst()
                .getAsInt();

        return answer;

        // 복잡도 계산..
//        String temp = String.valueOf(p);
//        String[] yearOfDigits = temp.split("");
//        int[]
    }

    private boolean isBeautifulYear(int year) {
        String temp = String.valueOf(year);
        String[] yearOfDigits = temp.split("");
        int lengthOfYear = yearOfDigits.length;
        int lengthOfDuplicationRemovedYear = Arrays.stream(yearOfDigits)
                .distinct()
                .toArray().length;

        return lengthOfDuplicationRemovedYear == lengthOfYear;
    }

    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        int p1 = 1987;
        int p2 = 2015;

        System.out.println(sol.solution(1987)); // 2013
        System.out.println(sol.solution(2015)); // 2016
    }

}
