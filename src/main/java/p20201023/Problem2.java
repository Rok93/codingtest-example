package p20201023;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem2 {
    private static final int[] DIAL_NUMBERS = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final String[] DIAL_WORDS = {"OPERATOR", " ", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    // 5622번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int sum = Arrays.stream(s.split(""))
                .mapToInt(Problem2::calculate)
                .sum();

        System.out.println(sum);
    }

    private static int calculate(String word) {
        return IntStream.rangeClosed(0, 9)
                .filter(index -> DIAL_WORDS[index].contains(word))
                .map(index -> DIAL_NUMBERS[index])
                .findAny()
                .getAsInt();
    }
}
