package p20201020;

import java.util.Scanner;
import java.util.Stack;

public class Problem2 {
    // 10773번 제로 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int value = sc.nextInt();

            if (value == 0) {
                stack.pop();
                continue;
            }

            stack.push(value);
        }

        System.out.println(stack.stream()
        .mapToInt(Integer::intValue)
        .sum());
    }
}
