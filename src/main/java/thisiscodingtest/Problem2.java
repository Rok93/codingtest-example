package thisiscodingtest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제 해설
 * 이 문제를 푸는 아이디어는 바로 '각 행마다
 */
// '이것이 코딩테스트다' 그리디 문제 : "숫자 카드 게임"
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] cards = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cards[i][j] = sc.nextInt();
            }
        }

        int maxNumber = Integer.MIN_VALUE;
        for (int[] card : cards) {
            int maxNumberInCard = Arrays.stream(card)
                    .min()
                    .getAsInt();
            maxNumber = maxNumber < maxNumberInCard ? maxNumberInCard : maxNumber;
        }
        System.out.println(maxNumber);
    }
}
