package study.dynamicprogramming;

import java.util.Scanner;

// 바닥의 길이가 증가할 때, 타일 중에 어떤 타일크기와 동일하게 증가하는가 ? (지금 같은 경우에는 2 x 1 씩 증가한다)
// 점화식을 짤 때, 이 2 x 1이 증가하는 경우와 ,  1 x 2 && 2 x 2 가 증가하는 경우를 따로 본다 !
/*
현재 길이가 i인 바닥이 있다고 보자! 그렇다면 아래와 같이 생각할 수 있다.
(1) 왼쪽부터 i - 1까지 길이가 덮개로 이미 채워져 있으면 2 x 1의 덮개를 채우는 하나의 경우밖에 존재하지 않는다.
(2) 왼쪽부터 i - 2까지 길이가 덮개로 이미 채워져 있다면, 1 x 2 덮개 2개를 넣는 경우, 혹은 2 x 2 덮개 하나를 넣는 경우로 2가지 경우가 존재한다.
점화식은 -->  A(n) = A(n - 1) + 2 * A(n - 2) 로 도출된다!
 */
public class Problem3_2 {
    private static int[] dp = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }

        System.out.println(dp[N]);
    }
}
