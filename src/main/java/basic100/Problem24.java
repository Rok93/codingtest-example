package basic100;

import java.util.Scanner;

public class Problem24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println(Integer.parseInt(input.split(":")[1]));
    }
}
