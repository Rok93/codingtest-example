package p20200804;

import java.util.Scanner;
import java.util.Stack;

public class Problem1 {
    static int evaluate(String str) {
        int len = str.length();
        int cur = 1;
        int sum = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            System.out.println(sum);
            switch (str.charAt(i)) {
                case '(':
                    stack.push('(');
                    cur *= 2;
                    break;

                case '[':
                    stack.push('[');
                    cur *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return 0;
                    if (str.charAt(i - 1) == '(') sum += cur;
                    stack.pop();
                    cur /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return 0;
                    if (str.charAt(i - 1) == '[') sum += cur;
                    stack.pop();
                    cur /= 3;
                    break;

            }
        }
        if (!stack.isEmpty()) return 0;
        return sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(evaluate(str));
    }
}

// 출처: https://zetawiki.com/wiki/BOJ_2504_%EA%B4%84%ED%98%B8%EC%9D%98_%EA%B0%92
