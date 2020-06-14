package p20200529;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Study3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputNumbers = sc.nextLine().split(" ");
        int start = Integer.parseInt(inputNumbers[0]);
        int end = Integer.parseInt(inputNumbers[1]);

        if (start < 2) start = 2;
        IntStream.rangeClosed(start, end)
                .filter(Study3::isPrimeNumber)
                .forEach(System.out::println);
    }

    public static boolean isPrimeNumber(int number) {
        int sqrtNumber = (int) Math.sqrt(number);
        return IntStream.rangeClosed(2, sqrtNumber)
                .allMatch(n -> number % n != 0);
    }
}
