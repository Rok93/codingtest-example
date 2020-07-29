package p20200520;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Study2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int tryNum = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tryNum; i++) {
            String temp = sc.next();

            if (temp.startsWith("push")) {
                int inputNumber = sc.nextInt();
                stack.push(inputNumber);
                continue;
            }

            if (temp.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
                continue;
            }

            if (temp.equals("size")) {
                System.out.println(stack.size());
                continue;
            }

            if (temp.equals("empty")) {
                if (stack.isEmpty()) { //비어있으면 1
                    System.out.println(1);
                    continue;
                }
                System.out.println(0); //아니면 0
                continue;
            }

            if (temp.equals("pop")) {
                if (stack.isEmpty()) { //비어있으면 -1
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.pop());
                continue;
            }
        }
    }
}
