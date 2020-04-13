package practice;

import java.util.stream.IntStream;

public class Problem2 {
    public int solution(int n) {
        int answer = (int) IntStream.rangeClosed(1, n)
                .filter(Problem2::isPrimeNumber)
                .count();
        return answer;
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
