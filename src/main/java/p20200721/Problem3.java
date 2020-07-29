package p20200721;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {
    private static int numberLength;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numberLength = sc.nextInt();
        int startNumber = 1;

        while (!isEqualToNumberLength(startNumber)) {
            startNumber *= 10;
        }

        String answer = IntStream.iterate(1, number -> number + 1)
                .boxed()
                .filter(Problem3::isEqualToNumberLength)
                .filter(Problem3::isAmazingPrimeNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(answer);
    }

    private static boolean isEqualToNumberLength(int number) {
        String stringValue = String.valueOf(number);
        return stringValue.length() == numberLength;
    }

    private static boolean isAmazingPrimeNumber(int number) {
        String stringValueOfNumber = String.valueOf(number);
        int numberLength = stringValueOfNumber.length();
        for (int i = 0; i < numberLength; i++) {
            String substringValue = stringValueOfNumber.substring(0, i + 1);
            if (!isPrimeNumber(Integer.valueOf(substringValue))) {
                return false;
            }
        }
        System.out.println(number);
        return true;
    }

    private static boolean isPrimeNumber(int number) {
        if (number <= 1) return false;

        int sqrtNumber = (int) Math.sqrt(number);
        for (int i = 2; i < sqrtNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
