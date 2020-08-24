package study.greedy;

import java.util.Arrays;

public class Problem5 {

    public int solution(int[] food_times, long k) {
        int lastIndex = -1;
        while (true) {
            if (k == 0) {
                return lastIndex + 1;
            }

            int remainingFoodNumber = countRemainingFoods(food_times);
            if (remainingFoodNumber == 0) {
                return -1;
            }

            if (k >= remainingFoodNumber) {
                subOneAllTimes(food_times);
                k -= remainingFoodNumber;
                lastIndex = 0;
                continue;
            }

            int length = food_times.length;
            lastIndex = 0;
            for (; lastIndex < length; lastIndex++) {
                int food_time = food_times[lastIndex];
                if (food_time == 0) {
                    continue;
                }

                food_time--;
                k--;

            }
        }
    }

    private int countRemainingFoods(int[] food_times) {
        return (int) Arrays.stream(food_times)
                .filter(time -> time != 0)
                .count();
    }

    private void subOneAllTimes(int[] food_times) {
        int length = food_times.length;
        for (int i = 0; i < length; i++) {
            food_times[i] = food_times[i] == 0 ? food_times[i] : food_times[i] - 1;
        }
    }
}
