package p20201021;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    private static final int[][] BOARD = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for (int i = 0; i < number; i++) {
            int xStart = sc.nextInt();
            int yStart = sc.nextInt();

            int xEnd = xStart + 10;
            int yEnd = yStart + 10;

            for (int j = xStart; j < xEnd; j++) {
                for (int k = yStart; k < yEnd; k++) {
                    BOARD[j][k] = 1;
                }
            }

        }

        long count = Arrays.stream(BOARD)
                .flatMapToInt(arr -> Arrays.stream(arr)
                        .filter(num -> num == 1))
                .count();

        System.out.println(count);
    }
}
