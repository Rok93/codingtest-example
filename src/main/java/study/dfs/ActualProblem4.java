package study.dfs;

//괄호 변환
public class ActualProblem4 {
    public String solution(String p) {
        if (isCorrect(p)) { // 올바른 괄호문자열!
            return p;
        }
        return editWord(p);
    }

    private boolean isCorrect(String s) {
        int repetitionNumber = s.length() / 2;
        String copiedP = s;
        for (int i = 0; i < repetitionNumber; i++) {
            copiedP = copiedP.replaceAll("\\(\\)", "");
        }

        return copiedP.isEmpty();
    }

    private String editWord(String p) {
        if (p.isEmpty()) {
            return p;
        }

        int findIndex = findUIndex(p);
        String u = p.substring(0, findIndex + 1);
        String v = p.substring(findIndex + 1);

        if (isCorrect(u)) {
            return u + editWord(v);
        }

        return "(" + editWord(v) + ")" + turnString(u.substring(1, u.length() - 1));
    }

    private String turnString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sb.append(")");
                continue;
            }

            sb.append("(");
        }

        return sb.toString();
    }

    private int findUIndex(String p) {
        int leftCnt = 0;
        int rightCnt = 0;

        int i = 0;
        while (true) {
            char c = p.charAt(i);
            if (c == '(') {
                leftCnt++;
            }

            if (c == ')') {
                rightCnt++;
            }

            if (leftCnt == rightCnt) {
                break;
            }

            i++;
        }

        return i;
    }
}
