package study.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] numbers = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = numbers[0]; // 첫 항을 집어 넣는다!

        int length = numbers.length;
        for (int i = 1; i < length; i++) {
            if (numbers[i] <= 1) {
                answer += numbers[i];
                continue;
            }

            answer *= numbers[i];
        }

        System.out.println(answer);
    }
}
