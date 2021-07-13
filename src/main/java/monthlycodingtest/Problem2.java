package monthlycodingtest;

import java.util.Stack;

public class Problem2 {

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String preS = s.substring(0, i);
            String subS = s.substring(i);

            if (isCorrectBracket(subS + preS)) {
                answer++;
            }

        }

        return answer;
    }

    private boolean isCorrectBracket(String s) {
        Stack<String> stack = new Stack<>();

        String[] arr = s.split("");
        for (String eachBracket : arr) {
            if (!stack.isEmpty() && isFindPairBracket(stack.peek(), eachBracket)) {
                stack.pop();
                continue;
            }

            stack.push(eachBracket);
        }

        return stack.isEmpty();
    }

    private boolean isFindPairBracket(String stackBracket, String targetBracket) {

        return (targetBracket.equals("]") && stackBracket.equals("["))
                || (targetBracket.equals("}") && stackBracket.equals("{"))
                || (targetBracket.equals(")") && stackBracket.equals("("));
    }

}
