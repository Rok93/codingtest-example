package study.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem2 {
    private static final String THREE = "3";
    private static final int SECOND_START = 0;
    private static final int SECOND_LIMIT = 60;
    private static final int MINUTE_START = 0;
    private static final int MINUTE_LIMIT = 60;
    private static final int HOUR_START = 0;
    private static final int HOUR_LIMIT = 12;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long answer = IntStream.rangeClosed(HOUR_START, N)
                .flatMap(hour -> IntStream.range(MINUTE_START, MINUTE_LIMIT)
                        .flatMap(minute -> IntStream.range(SECOND_START, SECOND_LIMIT)
                                .map(second -> combineTime(hour, minute, second))
                        )
                )
                .filter(time -> isTimeContainThree(time))
                .count();

        System.out.println(answer);
    }

    private static int combineTime(int hour, int minute, int second) {
        return Integer.parseInt(hour + "" + minute + "" + second);
    }

    private static boolean isTimeContainThree(int time) {
        String timeValue = String.valueOf(time);
        return Arrays.stream(timeValue.split(""))
                .anyMatch(number -> number.equals(THREE));
    }
}
