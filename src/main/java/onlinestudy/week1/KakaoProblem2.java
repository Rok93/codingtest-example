package onlinestudy.week1;

import java.util.Stack;

// 카카오 문제 : 괄호 문자
public class KakaoProblem2 {
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }

        if (isValidateBracket(p)) { // 옳바른 괄호열일 경우! 받아온 문자열 그대로 리턴
            return p;
        }

        return replaceValidateBracket(p); // 옳바르지 않으면 수정해서 반환!
    }

    private boolean isValidateBracket(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            stack.pop();
        }
        return true;
    }

    private String replaceValidateBracket(String p) {
        return replace(p);
    }

    private String replace(String p) {
        if (p.isEmpty()) {
            return "";
        }

        int uEndIndex = findUIndex(p);
        String u = p.substring(0, uEndIndex);
        String v = p.substring(uEndIndex);

        if (isValidateBracket(u)) { //u가 옳바르면 그대로 더해준다!
            return u + replace(v);
        }

        return "(" + replace(v) + ")" + reformBracket(u); // 옳바르지 않으면 재할당한다! (이 부분 제대로 읽어야 함)
    }

    private String reformBracket(String u) {
        int length = u.length();
        String sub = u.substring(1, length - 1);
        StringBuilder sb = new StringBuilder();
        for (char c : sub.toCharArray()) {
            if (c == '(') {
                sb.append(')');
                continue;
            }

            sb.append('(');
        }
        return new String(sb);
    }

    private int findUIndex(String p) {
        int leftNumber = 0;
        int rightNumber = 0;

        int index = 0;
        while (leftNumber == 0 || rightNumber == 0 || leftNumber != rightNumber) {
            char c = p.charAt(index++);

            if (c == '(') {
                leftNumber++;
                continue;
            }

            rightNumber++;
        }

        return index;
    }
}
