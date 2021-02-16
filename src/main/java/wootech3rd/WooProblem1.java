package wootech3rd;

import java.util.Arrays;

public class WooProblem1 {
    private static final String[] GRADES = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
    private static final int[] SCORES = {10, 9, 8, 7, 6, 5, 4, 3, 0};

    public int solution(String[] grades, int[] weights, int threshold) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            String grade = grades[i]; // grades 길이 1 ~ 1,000 이하
            int score = SCORES[Arrays.binarySearch(GRADES, grade)]; // 1 ~ 1,000
            sum += score * weights[i];
        }

        return sum - threshold;
    }
}
