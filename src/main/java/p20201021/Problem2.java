package p20201021;

import java.util.Scanner;

public class Problem2 {
    // 1748번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 0;

        int before = 1;
        int mock = 10;
        int cnt = 1;
        while (N / mock != 0) {
            if (mock > N) {
                mock = N;
            }

            for (int i = before; i < mock; i++) {
                sum += cnt;
            }

            cnt++;
            before = mock;
            mock *= 10;
        }

        for (int i = before; i <= N; i++) {
            sum += cnt;
        }

        System.out.println(sum);
    }
}
