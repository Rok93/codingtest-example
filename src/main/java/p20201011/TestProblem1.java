package p20201011;

import java.util.Arrays;

public class TestProblem1 {
    private static int[] dpTable = new int[32001];

    public int solution(int N, int number) {
        if (N == 1) {
            return number;
        }

        Arrays.fill(dpTable, (int) 1e9);

        dpTable[1] = 2;
        dpTable[N] = 1;
        dpTable[11] = 3;
        for (int i = 2; i < N; i++) {
            dpTable[i] = Math.min(dpTable[i - 1] + dpTable[1], dpTable[N] + dpTable[N - i]);
        }

        for (int i = 1; i * N < number; i++) {
            dpTable[i * N] = i;
        }

        for (int i = N + 1; i <= number; i++) {
            int a = i % N;
            for (int j = 1; j < N; j++) {
                dpTable[i] = Math.min(dpTable[i], dpTable[i - j] + dpTable[j]);
            }
        }

        System.out.println(Arrays.toString(dpTable));

        int answer = 0;
        return answer;
    }
}
