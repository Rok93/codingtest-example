package p20201023;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem3 {
    // 2292번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1 -> 2 -> 9 -> 22 -> 41 -> 66   (+1, +7, +13, +20)
        // 1 -> 3 -> 11 -> 25 -> 45 (+2, +8,
        // 1 -> 4 -> 13 -> 28 -> 49
        // 1 -> 5 -> 15 -> 31 -> 53
        // 1 -> 6 -> 17 -> 34 -> 57
        // 1 -> 7 -> 19 -> 37

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int start = 0;
        int end = 1;
        int cnt = 0;
        int n = 1;
        while (true) {
            System.out.println("start: " + start + " end: " + end);
            if (start <= N && N <= end) {
                System.out.println(n);
                return;
            }

            start = end + 1;
            end += 6 * n;
            n++;
        }
    }
}
