package practice.kakao2021;

import java.util.Stack;

public class Problem2 {
    public String solution(String p) {
        if (isRightBracket(p)) {
            return p;
        }

        StringBuilder answer = new StringBuilder();

        correctP(p, answer);

        return answer.toString();
    }

    private void correctP(String p, StringBuilder answer) {
        String u = "";
        String v = "";
        for (int i = 1; i < p.length(); i += 2) {
            u = p.substring(0, i + 1);
            v = p.substring(i + 1);

            if (isPairBracket(u)) {
                break;
            }
        }

        //u 처리
        if (isRightBracket(u)) { //u가 옳바른 괄호
            answer.append(u);
            correctP(v, answer);
        } else { // u가 옳바르지 않은 괄호
            StringBuilder newU = new StringBuilder();
            String uSubString = "";
            if (u.length() > 2) {
                uSubString = u.substring(1, u.length() - 1);
            }

            newU.append("(");
            //v 처리
            if (isRightBracket(v)) { //비어 있는 값이 아니라면
                newU.append(v);
            } else {
                correctP(v, newU);
            }
            newU.append(")");

            String[] uSubStrings = uSubString.split("");
            for (String s : uSubStrings) {
                if (s.equals("(")) {
                    newU.append(")");
                    continue;
                }

                if (s.equals(")")) {
                    newU.append("(");
                }
            }
            answer.append(newU.toString());
        }
    }

    private boolean isRightBracket(String p) {
        String[] ps = p.split("");
        Stack stack = new Stack();
        for (String s : ps) {
            if (s.equals("(")) {
                stack.push(s);
                continue;
            }

            if (s.equals(")")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    //String u, v 로 분리한다.
    private boolean isPairBracket(String u) {
        String[] us = u.split("");
        int cnt = 0;
        for (String s : us) {
            if (s.equals("(")) {
                cnt++;
                continue;
            }
            cnt--;
        }
        return cnt == 0;
    }
}
