package basic100;

import java.util.Scanner;

public class Problem21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println(input.split("\\.")[0]);
        System.out.println(input.split("\\.")[1]);
    }
}
