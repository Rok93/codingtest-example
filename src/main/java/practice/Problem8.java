package practice;

//DFS의 느낌이 든다. 깊게 깊게 (피타고라스)
public class Problem8 {
    public int solution(int n) {
        int[] answer = new int[n + 1];
        answer[1] = 1;
        answer[2] = 2;

        for (int i = 3; i <= n; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1000000007;
        }
        return answer[n];
    }

    public static void main(String[] args) {
        Problem8 sol = new Problem8();
        int n = 50;
        sol.solution(50);
    }

}
