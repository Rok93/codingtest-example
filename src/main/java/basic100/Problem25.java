package basic100;

import java.util.Scanner;

public class Problem25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] inputs = input.split("\\.");

        int year = Integer.parseInt(inputs[0]);
        int month = Integer.parseInt(inputs[1]);
        int day = Integer.parseInt(inputs[2]);

        System.out.printf("%02d-%02d-%04d", day, month, year);
    }
}
