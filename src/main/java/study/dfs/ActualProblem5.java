package study.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActualProblem5 {
    private static final int PLUS = 0;
    private static final int MINUS = 1;
    private static final int MULTIPLE = 2;
    private static final int DIVIDER = 3;

    private static int[] operators = new int[4];
    private static int[] numbers;
    private static int N;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 수의 개수 (2 <= N <= 11)
        N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) { // A1, A2, A3 ... (1 <= Ai <= 100)
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt(); // (+), (-), (x), (/) 갯수
        }

        dfs(operators.clone(), 0, numbers[0]);

        System.out.println(answer.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt());

        System.out.println(answer.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt());
    }

    private static void dfs(int[] operator, int index, int result) {
        if (index >= N - 1) {
            answer.add(result);
            return;
        }

        if (operator[PLUS] > 0) {
            operator[PLUS]--;
            dfs(operator.clone(), index + 1, result + numbers[index + 1]);
            operator[PLUS]++;
        }

        if (operator[MINUS] > 0) {
            operator[MINUS]--;
            dfs(operator.clone(), index + 1, result - numbers[index + 1]);
            operator[MINUS]++;
        }

        if (operator[MULTIPLE] > 0) {
            operator[MULTIPLE]--;
            dfs(operator.clone(), index + 1, result * numbers[index + 1]);
            operator[MULTIPLE]++;
        }

        if (operator[DIVIDER] > 0) {
            operator[DIVIDER]--;
            dfs(operator.clone(), index + 1, result / numbers[index + 1]);
            operator[DIVIDER]++;
        }

    }
}
