package programmers.backend;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public int solution(int[] numbers, int K) {
        int answer = 0;

        List<Integer> gapList = new ArrayList<>();

        // gap 차이 구하기!
        for (int i = 0; i < numbers.length - 1; i++) {
            gapList.add(Math.abs(numbers[i] - numbers[i + 1]));
        }

        int cnt = 0;
        while (cnt < getMaxTryNumber(numbers) && !isGapUnderK(K, gapList)) {
            cnt++;
            int maxGap = gapList.stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .getAsInt();

            int minGap = gapList.stream()
                    .mapToInt(Integer::intValue)
                    .min()
                    .getAsInt();

            int biggerMax = 0;
            int lowerMin = 0;
            for (int i = 0; i < gapList.size(); i++) {

                if (gapList.get(i).equals(maxGap)) {
                    biggerMax = gapList.get(i) > gapList.get(i + 1) ? gapList.get(i) : gapList.get(i + 1);
                    continue;
                }

                if (gapList.get(i).equals(minGap)) {
                    lowerMin = gapList.get(i) < gapList.get(i + 1) ? gapList.get(i) : gapList.get(i + 1);
                }
            }
            int temp = numbers[biggerMax];
            numbers[biggerMax] = numbers[lowerMin];
            numbers[lowerMin] = temp;

        }


        return answer;
    }

    private boolean isGapUnderK(int K, List<Integer> gapList) {
        return gapList.stream()
                .anyMatch(number -> number > K);
    }

    private int getMaxTryNumber(int[] numbers) {
        int answer = 1;
        for (int i = 1; i <= numbers.length; i++) {
            answer *= i;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
