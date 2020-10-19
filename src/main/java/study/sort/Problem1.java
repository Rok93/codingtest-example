package study.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// p.178 정렬 : 위에서 아래로
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Integer[] arr = new Integer[number];
        for (int i = 0; i < number; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 주의 Collections.reverseOrder() ... 쓰려면 래퍼 클래스 여야 한다!

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
