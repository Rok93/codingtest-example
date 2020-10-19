package p20200520;

import java.util.Scanner;
import java.util.Stack;

public class Study3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNumber = sc.nextInt();

        for (int i = 0; i < tryNumber; i++) {
            String temp = sc.next();
            isRight(temp);
        }
    }

    private static void isRight(String temp) {
        Stack<String> stack = new Stack<>();
        String[] splitTemp = temp.split("");
        int tempLen = temp.length();

        if (tempLen % 2 != 0) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < tempLen; i++) {
            String curTemp = splitTemp[i];

            if (curTemp.equals("(")) {
                stack.push(curTemp);
                continue;
            }

            if (curTemp.equals(")")) {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
