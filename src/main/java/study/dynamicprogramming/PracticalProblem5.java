package study.dynamicprogramming;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PracticalProblem5 {
    public static void main(String[] args) {
        // 못생긴 수: 2, 3, 5만을 소인수 (Prime Factor)로 가지는 수를 의미한다.
        // 다시 말해 오직 2, 3, 5를 약수로 가지는 합성수를 의미한다.
        // 1은 못생긴 수라고 가정한다.
        // ex) 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15.... 순으로 이어지게 된다. 이 때, n번째 못생긴 수를 찾는 프로그램을 작성하라. ex) n = 11, 결과: 15

        int[] group = {1, 2, 3, 5};
        boolean[] dpTable = new boolean[1001];
        for (int i = 0; i < 4; i++) {
            dpTable[group[i]] = true;
        }

        for (int i = 1; i < 1001; i++) {
            if (dpTable[i]) {
                for (int j = 0; j < 4; j++) {
                    int index = i * group[j];
                    if (index <= 1000) {
                        System.out.print(index + " ");
                        dpTable[index] = true;
                    }
                }
                System.out.println();
            }
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] answers = IntStream.range(1, 1001)
                .filter(index -> dpTable[index])
                .limit(n)
                .toArray();

        System.out.println(answers[n - 1]);
    }
}
