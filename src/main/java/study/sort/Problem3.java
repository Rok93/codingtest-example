package study.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // 총 K 번의 바꿔치기!  최종 목표는 배열 A의 모든 원소의 합이 최대가 되도록 하는 것!
        for (int i = 0; i < K; i++) {
            Arrays.sort(A);
            Arrays.sort(B, Comparator.reverseOrder());

            if (A[0] < B[0]) {
                int temp = A[0];
                A[0] = B[0];
                B[0] = temp;
            }
        }

        System.out.println(Arrays.stream(A)
                .mapToInt(Integer::intValue)
                .sum());

    }
}
