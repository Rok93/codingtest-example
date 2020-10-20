package p20101020;

import java.util.Scanner;
import java.util.Stack;

public class Problem1 {
    // 10773번
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int tryNumber = sc.nextInt();

        for (int i = 0; i < tryNumber; i++) {
            int input = sc.nextInt();

            if (input == 0) {
                stack.pop();
                continue;
            }

            stack.push(sc.nextInt());
        }

        int sum = stack.stream()
                .mapToInt(Integer::new)
                .sum();
        System.out.println(sum);
    }
}
