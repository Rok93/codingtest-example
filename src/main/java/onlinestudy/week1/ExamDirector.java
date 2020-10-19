package onlinestudy.week1;

import java.util.Arrays;
import java.util.Scanner;

// 시험 감독
public class ExamDirector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 시험장의 개수
        int[] classes = new int[N];
        for (int i = 0; i < N; i++) {
            classes[i] = sc.nextInt(); // 각 시험장의 응시자 수
        }
        int B = sc.nextInt(); // 총 감독관이 한 번에 감시할 수 있는 인원 (한 시험장 당 1명 고정) (1 ~ 1,000,000)
        int C = sc.nextInt(); // 부 감독관이 한 번에 감시할 수 있는 인원 (한 시험장 당 다수 가능), (1 ~ 1,000,000)

        long sum = Arrays.stream(classes)
                .mapToObj(Integer::new)
                .mapToLong(candidateNumber -> needDirectorNumber(candidateNumber, B, C))
                .sum();
        System.out.println(sum);
    }

    private static long needDirectorNumber(int candidateNumber, int B, int C) {
        int count = 0;
        candidateNumber = candidateNumber - B >= 0 ? candidateNumber - B : 0;
        count += 1;

        if (candidateNumber == 0) {
            return count;
        }

        int needSecondDirectorNumber = (int) Math.ceil((double) candidateNumber / C);
        count += needSecondDirectorNumber >= 0 ? needSecondDirectorNumber : 0;

        return count;
    }
}
