package n20200605;

import java.util.Arrays;
import java.util.Scanner;

public class Study2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int[] trees = new int[number];
        for (int i = 0; i < number; i++) {
            trees[i] = sc.nextInt();
        }

        int[] gaps = new int[number - 1];

        for (int i = 0; i < number - 1; i++) {
            gaps[i] = trees[i + 1] - trees[i];
        }

        Arrays.sort(gaps); //오름차순으로 정렬

        int answer = 0;
        int minGap;
        while (true) {
            if (gaps[0] % (answer + 1) != 0) {
                answer++;
                continue;
            }

            minGap = gaps[0] / (answer + 1);
            int cnt = 0;
            int temp = 0;
            for (int i = 1; i < number - 1; i++) {
                if (gaps[i] % minGap == 0) {
                    cnt++;
                    temp += (gaps[i] / minGap) - 1;
                    continue;
                }
                break;
            }

            if (cnt == number - 2) {
                answer += temp;
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
