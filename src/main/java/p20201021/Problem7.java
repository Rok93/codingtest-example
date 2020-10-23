package p20201021;

import java.util.Arrays;
import java.util.Scanner;

public class Problem7 {
    private static final int[] NUMBERS = new int[10];

    // 1475번 방번호
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Arrays.stream(String.valueOf(N).split(""))
                .mapToInt(Integer::parseInt)
                .forEach(num -> NUMBERS[num]++);

        if (NUMBERS[6] != NUMBERS[9]) {
            int sum = NUMBERS[6] + NUMBERS[9];
            if (sum > 1) {
                int mid = (int) Math.ceil((double) sum / 2);
                NUMBERS[6] = mid;
                NUMBERS[9] = mid;
            }
        }

        int max = Arrays.stream(NUMBERS)
                .max()
                .getAsInt();

        System.out.println(max);
    }
}
