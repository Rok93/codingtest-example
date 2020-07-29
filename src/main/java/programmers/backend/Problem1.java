package programmers.backend;

public class Problem1 {
    public int solution(String p, String s) {
        int answer = 0;
        String[] splitedP = p.split("");
        String[] splitedS = s.split("");

        for (int i = 0; i < splitedP.length; i++) {
            int intP = Integer.parseInt(splitedP[i]);
            int intS = Integer.parseInt(splitedS[i]);
            answer += getMinGap(intP, intS);

        }
        return answer;
    }

    private int getMinGap(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return (a - b) < 10 - (a - b) ? (a - b) : 10 - (a - b);
    }

    public static void main(String[] args) {
    }

}
