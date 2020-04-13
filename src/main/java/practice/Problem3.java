package practice;

public class Problem3 {
    public String solution(int n) {
        String[] watermelon = {"수", "박"};
        String answer = "";

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt >= watermelon.length) {
                cnt = 0;
            }
            answer += watermelon[cnt++];
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
