package study.search;

import java.util.Arrays;
import java.util.Scanner;

// p.201 이진탐색 : 떡볶이 떡 만들기
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] goods = new int[N];

        for (int i = 0; i < N; i++) {
            goods[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] needGoods = new int[M];
        for (int i = 0; i < M; i++) {
            needGoods[i] = sc.nextInt();
        }

        Arrays.sort(needGoods);

        for (int need : needGoods) {
            int findIndex = Arrays.binarySearch(goods, need);

            if (findIndex < 0) {
                System.out.print("no ");
                continue;
            }

            System.out.print("yes ");
        }
    }
}
