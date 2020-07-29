package line;

import java.util.Stack;

public class Problem1 {
    public int solution(String inputString) {
        int answer = 0;
        //정상: 괄호쌍 갯수, 비정상: -1
        Stack<String> stack1 = new Stack<>(); // { stack
        Stack<String> stack2 = new Stack<>(); // ( stack
        Stack<String> stack3 = new Stack<>(); // [ stack
        Stack<String> stack4 = new Stack<>(); // < stack

        String[] inputStrings = inputString.split("");

        for (int i = 0; i < inputStrings.length; i++) {
            if (inputStrings[i].equals("{")) {
                stack1.push(inputStrings[i]);
                continue;
            }
            if (inputStrings[i].equals("}")) {
                if (stack1.isEmpty()) {
                    return -1;
                }
                stack1.pop();
                answer++;
                continue;
            }

            if (inputStrings[i].equals("(")) {
                stack2.push(inputStrings[i]);
                continue;
            }
            if (inputStrings[i].equals(")")) {
                if (stack2.isEmpty()) {
                    return -1;
                }
                stack2.pop();
                answer++;
                continue;
            }

            if (inputStrings[i].equals("[")) {
                stack3.push(inputStrings[i]);
                continue;
            }
            if (inputStrings[i].equals("]")) {
                if (stack3.isEmpty()) {
                    return -1;
                }
                stack3.pop();
                answer++;
                continue;
            }

            if (inputStrings[i].equals("<")) {
                stack4.push(inputStrings[i]);
                continue;
            }
            if (inputStrings[i].equals(">")) {
                if (stack4.isEmpty()) {
                    return -1;
                }
                stack4.pop();
                answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        String input1 = "Hello, world!";
        String input2 = "line [plus]";
        String input3 = "if (Count of eggs is 4.) {Buy milk.}";
        String input4 = ">_<";
        System.out.println(sol.solution(input1));
        System.out.println(sol.solution(input2));
        System.out.println(sol.solution(input3));
        System.out.println(sol.solution(input4));
    }
}
