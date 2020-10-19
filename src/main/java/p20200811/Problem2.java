package p20200811;

import java.util.Arrays;

public class Problem2 {
    public int solution(int distance, int[] rocks, int n) {
        int max = 0;
        Arrays.sort(rocks);

        int left = 1, right = distance, mid = 0;
        while (left <= right) {
            int cnt = 0, prev = 0, min = distance;
            mid = (left + right) / 2;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev <= mid) cnt++;
                else {
                    min = Math.min(min, rocks[i] - prev);
                    prev = rocks[i];
                }
            }
            if (distance - prev <= mid) cnt++;
            else min = Math.min(min, distance - prev);

            if (cnt == n) {
                max = Math.max(max, min);
                left = mid + 1;
            } else right = mid - 1;
        }

        return max;
    }
}
