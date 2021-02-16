package wootech3rd;

public class WooProblem2 {
    public long[] solution(String s, String op) {
        long[] answer = new long[s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            long firstValue = Long.parseLong(s.substring(0, i + 1));
            long secondValue = Long.parseLong(s.substring(i + 1));

            answer[i] = calculateOp(firstValue, secondValue, op);
        }

        return answer;
    }

    private long calculateOp(long a, long b, String op) {
        if (op.equals("+")) {
            return a + b;
        }

        if (op.equals("-")) {
            return a - b;
        }

        return a * b;
    }
}
