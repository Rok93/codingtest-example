package study.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class PracticalProblem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] T = new int[N];
        int[] P = new int[N];
        int[] dpTable = new int[N + 1];

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                int maxValueIndex = i;
                while (maxValueIndex > 0 && dpTable[maxValueIndex] == 0) {
                    maxValueIndex--;
                }
                if (maxValueIndex < i) {
                    Arrays.fill(dpTable, maxValueIndex + 1, i + 1, dpTable[maxValueIndex]);
                }

                dpTable[i + T[i]] = Math.max(P[i] + dpTable[maxValueIndex], dpTable[i + T[i]]);
            }
        }
        int max = Arrays.stream(dpTable)
                .max()
                .getAsInt();
        System.out.println(max);
    }
}

/*
Ex1)
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

Ex2)
10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10

Ex3)
10
5 10
5 9
5 8
5 7
5 6
5 10
5 9
5 8
5 7
5 6

Ex4)
10
5 50
4 40
3 30
2 20
1 10
1 10
2 20
3 30
4 40
5 50

 */
