package study.greedy;

import java.util.*;
import java.util.stream.IntStream;

// 그리디 문제 : 만들 수 없는 금액
public class Solution3 {

    private static List<Integer> sums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinNumber = sc.nextInt();
        int[] monetaryUnits = new int[coinNumber];
        for (int i = 0; i < coinNumber; i++) {
            monetaryUnits[i] = sc.nextInt();
        }

        Arrays.sort(monetaryUnits);

        sums = new ArrayList<>();

        for (int i = 0; i < coinNumber; i++) {
            sumUnit(monetaryUnits, i, 0);
        }

        Collections.sort(sums);

        System.out.println(sums);

        int answer = IntStream.iterate(1, n -> n + 1)
                .boxed()
                .filter(num -> !sums.contains(num))
                .findFirst()
                .get();

        System.out.println(answer);
    }

    private static void sumUnit(int[] monetaryUnits, int currentIndex, int sum) {
        if (currentIndex == monetaryUnits.length) {
            sums.add(sum);
            return;
        }

        sumUnit(monetaryUnits, currentIndex + 1, sum + monetaryUnits[currentIndex]);
        sumUnit(monetaryUnits, currentIndex + 1, sum);
    }
}
