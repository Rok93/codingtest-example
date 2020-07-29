package jaehong;

import java.util.Arrays;

public class CodingTestExample {
    private int[] restaurant;
    private int k;

    public int solution(int[] restaurant, int[][] riders, int k) {
        this.restaurant = restaurant;
        this.k = k;

        return (int) Arrays.stream(riders)
                .filter(this::isCloserThanK)
                .count();
    }

    private boolean isCloserThanK(int[] rider) {
        int xLength = rider[0] - restaurant[0];
        int yLength = rider[1] - restaurant[1];

        return generateSquare(xLength) + generateSquare(yLength) <= generateSquare(k);
    }

    private int generateSquare(int value) {
        return value * value;
    }

    public static void main(String[] args) {
        int[] restaurant = new int[]{0, 0};
        int k = 1000;
        int[][] riders = {{-700, 0}, {150, 180}, {500, 500}, {150, -800}, {800, 800}, {-900, 500}, {-1100, 900}};

        CodingTestExample sol = new CodingTestExample();
        int answer = sol.solution(restaurant, riders, k);
        System.out.println("결과값 = " + answer);
    }
}
