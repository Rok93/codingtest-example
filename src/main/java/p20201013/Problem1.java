package p20201013;

import java.util.Scanner;

public class Problem1 {
    // 2875번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt(); // 인턴쉽 참가 인원

        // 대회  여자 2 + 남자 1
        // 6 3 2
        int teamNumber = 0;
        while (N > 1 && M > 0) {
            if (N - 2 < 0) {
                break;
            }
            teamNumber++;
            N -= 2;
            M--;
        }

        while (K > 0 && (N > 0 || M > 0)) {
            if (N > 0) {
                N--;
                K--;
                continue;
            }

            M--;
            K--;
        }

        if (K == 0) {
            System.out.println(teamNumber);
            return;
        }

        int minus = (int) Math.ceil((double) K / 3);
        System.out.println(teamNumber - minus);
    }
}
