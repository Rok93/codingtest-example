package wootech2nd20201101;

import java.util.Arrays;

public class Problem1 {
    public int solution(int[] restaurant, int[][] riders, int k) {
        return (int) Arrays.stream(riders)
                .filter(rider -> isInboundary(restaurant, rider, k))
                .count();
    }

    private boolean isInboundary(int[] target, int[] rider, int k) {
        int differenceX = Math.abs(target[0] - rider[0]);
        int differenceY = Math.abs(target[1] - rider[1]);

        return doubleValue(differenceX) + doubleValue(differenceY) <= k * k;

    }

    private int doubleValue(int number) {
        return number * number;
    }
}
