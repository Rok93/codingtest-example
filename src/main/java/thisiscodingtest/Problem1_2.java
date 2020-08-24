package thisiscodingtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// '이것이 코딩테스트다' 그리디 문제 : 큰 수의 법칙
public class Problem1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberAmount = sc.nextInt();
        int M = sc.nextInt(); // 더해지는 횟수
        int K = sc.nextInt(); // 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징

        Integer[] numbers = new Integer[numberAmount];
        for (int i = 0; i < numberAmount; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers, Collections.reverseOrder());

        int largestNumber = numbers[0];
        int secondLargestNumber = numbers[1];

        int sum = 0;
        int sectionSum = K * largestNumber + secondLargestNumber;
        sum += M / (K + 1) * sectionSum;

        if (M % (K + 1) != 0) {
            sum += (M % (K + 1) * largestNumber);
        }

        System.out.println(sum);
    }
}
