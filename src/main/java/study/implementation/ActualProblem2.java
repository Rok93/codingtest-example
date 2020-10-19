package study.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class ActualProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String alphabets = input.replaceAll("\\d", "");
        Arrays.stream(alphabets.split(""))
                .sorted()
                .forEach(System.out::print);

        String numbers = input.replaceAll("\\D", "");
        int sum = Arrays.stream(numbers.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);
    }
}
