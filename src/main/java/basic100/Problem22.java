package basic100;

import java.util.Scanner;

public class Problem22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        for (char c : input.toCharArray()) {
            System.out.println("'" + c + "'");
        }
    }
}
