package basic100;

import java.util.Scanner;

public class Problem16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String hour = input.split(":")[0];
        String min = input.split(":")[1];

        System.out.printf("%s:%s",hour,min);
    }
}
