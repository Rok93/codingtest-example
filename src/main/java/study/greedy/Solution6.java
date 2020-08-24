package study.greedy;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution6 {
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 볼링 공의 개수
        int M = sc.nextInt(); // 공의 최대 무게
        int[] balls = new int[N];
        IntStream.range(0, balls.length)
                .forEach(index -> balls[index] = sc.nextInt());

        answer = 0;
        for (int i = 0; i < balls.length - 1; i++) {
            dfs(balls, i);
        }

        System.out.println(answer);
    }

    private static void dfs(int[] balls, int i) {
        int length = balls.length;
        for (int j = i + 1; j < length; j++) {
            if (balls[i] == balls[j]) {
                continue;
            }

            answer++;
        }
    }
}
