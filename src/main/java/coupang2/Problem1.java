package coupang2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem1 {
    public int solution(int n) {
        //java의 int형의 범위  -2147483648 ~ 2147483647  (== 2^31 -1 범위는 주어진 조건이 int형 범위 만족한다)
        int answer = getSumOfDigit(n);
        while (answer / 10 != 0) {
            answer = getSumOfDigit(answer);
        }
        return answer;
    }

    private int getSumOfDigit(int n) {
        String temp = String.valueOf(n);
        String[] numberDigits = temp.split(""); //한자리씩 분리

//        IntStream.rangeClosed(n, n)
//                .boxed()
//                .map(String::valueOf)
//                .map(year -> year.split(""))
//                .

        return Arrays.stream(numberDigits)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        int n1 = 10;
        int n2 = 456789;
        System.out.println(sol.solution(n1)); // 1
        System.out.println(sol.solution(n2)); // 3
    }
}
