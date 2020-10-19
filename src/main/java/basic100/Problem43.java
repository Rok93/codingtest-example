package basic100;

import java.util.Scanner;

public class Problem43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] list = input.split(" ");

        long a = Long.parseLong(list[0]);
        long b = Long.parseLong(list[1]);
        long c = Long.parseLong(list[2]);
        double average = ((double) (a + b + c) / 3);
        long sum = a + b + c;

        System.out.println(sum);
        System.out.printf("%.1f", average);
    }
}
