package basic100;

import java.util.Scanner;

public class Problem38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char c = input.charAt(0);
        char result = (char) (c + 1);
        System.out.println(result);
    }
}
