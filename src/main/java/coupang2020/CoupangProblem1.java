package coupang2020;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CoupangProblem1 {
    private int[] answer = new int[11];

    public int[] solution(int N) {
        // N을 1 ~ 10 진법으로 나타내려고 할 때, 자릿수 곱이 최대가 되는 k와 그때의 자릿수 곱을 구하라
        // 만약 자릿수 곱이 최대가 되는 k가 여러 개 있다면 그 중 가장 큰 k를 구하라,
        answer[1] = 1;
        IntStream.rangeClosed(2, 10)
                .forEach(k -> answer[k] = getMultipleN(k, N));

        int maxValue = Arrays.stream(answer)
                .max()
                .getAsInt();

        for (int i = 10; i > 0; i--) {
            if (answer[i] == maxValue) {
                return new int[]{i, answer[i]};
            }
        }

        return new int[]{};
    }

    private int getMultipleN(int N, int value) {
        int answer = 1;
        while (value / N != 0) {
            int rest = value % N;

            if (rest != 0) {
                answer *= rest;
            }

            value /= N;
        }

        if (value != 0) {
            answer *= value;
        }

        return answer;
    }
}
