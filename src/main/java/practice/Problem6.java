package practice;

import java.util.stream.IntStream;

public class Problem6 {
    public int solution(int n) {
        int answer = IntStream.rangeClosed(1, n)
                .filter(number -> n % number == 0)
                .sum();
        return answer;
    }
}
