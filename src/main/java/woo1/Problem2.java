package woo1;

import java.util.stream.IntStream;

public class Problem2 {
    public boolean solution(int[][] lands, int[][] wells, int[] points) {
        boolean result = isContainsWellsInPoint(points, wells) && isNotContainsLandsInPoint(points, lands);
        return result;
    }

    private boolean isNotContainsLandsInPoint(int[] points, int[][] lands) {
        int landsNumber = lands.length;
        return IntStream.range(0, landsNumber)
                .allMatch(index -> isNotContainsThat(points, lands[index]));
    }

    private boolean isContainsWellsInPoint(int[] points, int[][] wells) {
        int wellsNumber = wells.length;
        return IntStream.range(0, wellsNumber)
                .anyMatch(index -> !isNotContainsThat(points, wells[index]));
    }

    private boolean isNotContainsThat(int[] points, int[] that) {
        int wellRX = that[2];
        int wellLX = that[0];
        int pointsRX = points[2];
        int pointsLX = points[0];

        int wellLY = that[1];
        int wellHY = that[3];
        int pointsLY = points[1];
        int pointsHY = points[3];


        if ((wellRX <= pointsLX) || (wellLX >= pointsRX) ||
                (wellLY >= pointsHY) || (wellHY <= pointsLY)) {
            return true;
        }
        return false;
    }
}
