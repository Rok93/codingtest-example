package wootech2nd20201101;

import java.util.Arrays;

public class Problem2 {
    public int[] solution(String logs) {
        int[] answer = new int[24];
        Arrays.stream(logs.split("\n"))
                .mapToInt(this::getKoreanTime)
                .forEach(time -> answer[time]++);

        return answer;
    }

    private int getKoreanTime(String dateData) {
        return Integer.parseInt(dateData.split(" ")[1].split(":")[0]) + 9;
    }
}
