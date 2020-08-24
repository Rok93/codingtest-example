package woo2;

import java.util.Arrays;

public class Problem1 {
    private static final int X_COORDINATE = 0;
    private static final int Y_COORDINATE = 1;
    private static final int DISTANCE_COMPARE_NUMBER = 0; // 변수명... 맘에 안듦

    public int solution(int[] restaurant, int[][] riders, int k) {
        return (int) Arrays.stream(riders)
                .mapToInt(rider -> calculateDistance(restaurant, rider))
                .filter(distance -> isInsideRangeThat(distance, k))
                .count();
    }

    private boolean isInsideRangeThat(int distance, int range) {
        return range - distance >= DISTANCE_COMPARE_NUMBER ? true : false;
    }

    private int calculateDistance(int[] restaurant, int[] item) {
        int widthGap = restaurant[X_COORDINATE] - item[X_COORDINATE];
        int heightGap = restaurant[Y_COORDINATE] - item[Y_COORDINATE];

        return (int) Math.sqrt(square(widthGap) + square(heightGap));
    }

    private int square(int number) {
        return number * number;
    }
}
