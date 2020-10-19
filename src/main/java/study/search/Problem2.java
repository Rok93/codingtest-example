package study.search;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] riceCakes = new int[N];
        for (int i = 0; i < N; i++) {
            riceCakes[i] = sc.nextInt();
        }

        Arrays.sort(riceCakes);

        int start = 0;
        int end = riceCakes[N - 1];
        int mid;
        int total;
        while (start <= end) {
            total = 0;
            mid = (start + end) / 2;

            for (int riceCake : riceCakes) {
                if (riceCake > mid) {
                    total += riceCake - mid;
                }
            }

            if (total == M) {
                System.out.println(mid);
                return;
            }

            if (total < M) {
                end = mid - 1;
                continue;
            }

            start = mid + 1;
        }

        System.out.println("값이 안나옴 ...ㅠ");

//        int answer = binarySearch(riceCakes, 0, (int) 1e9, M); // 0 ~ 떡의 최대 길이 넣는다!

//        System.out.println(answer);
    }

    private static int binarySearch(int[] riceCakes, int left, int right, int m) {
        int mid = (left + right) / 2;
        int restRiceCakes = getRestRiceCake(riceCakes, mid);

        if (restRiceCakes == m) {
            return mid;
        }

        if (m > restRiceCakes) {
            return binarySearch(riceCakes, left, mid - 1, m);
        }

        return binarySearch(riceCakes, mid + 1, right, m);
    }

    private static int getRestRiceCake(int[] riceCakes, long mid) {
        return Arrays.stream(riceCakes)
                .boxed()
                .mapToInt(riceCake -> riceCake - mid > 0 ? (int) (riceCake - mid) : 0)
                .sum();
    }
}
