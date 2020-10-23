package p20201023.combinecodingtest;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        boolean result = Arrays.stream(arr)
                .anyMatch(number -> number == k);

        System.out.println(result ? "YES" : "NO");
    }
}
