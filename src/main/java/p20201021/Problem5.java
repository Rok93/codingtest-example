package p20201021;

import java.util.Scanner;

public class Problem5 {
    private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;

    // 15685번 드래곤 커브
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 드래곤 커브의 개수 (1 <= N <= 20)

        for (int i = 0; i < N; i++) {
            int y = sc.nextInt(); // (프로그래밍과 x, y 가 역전된다 참고하자!)
            int x = sc.nextInt(); // 0 <= x, y <= 100

            int d = sc.nextInt(); // 0 <= d <= 3
            int g = sc.nextInt(); // 세대 (0 <= g <= 10)
        }

    }
}
