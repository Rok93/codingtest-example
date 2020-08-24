package study.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 그리디 문제 : 곱하기 혹은 더하기 (나의 풀이)
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] numbers = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            if ((numbers[i] == 0 || numbers[i + 1] == 1) || (numbers[i + 1] == 0 || numbers[i + 1] == 1)) {
                numbers[i + 1] += numbers[i];
                continue;
            }
            numbers[i + 1] *= numbers[i];
        }

        System.out.println(numbers[length - 1]);
    }
}
