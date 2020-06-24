package iPortpfolio;

import java.util.Stack;

public class Problem3 {
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;

    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        char[] ss = s.toCharArray();

        for (char c : ss) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        if (stack.isEmpty()) {
            return SUCCESS;
        }
        return FAIL;
    }
}
