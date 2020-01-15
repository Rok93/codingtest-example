package basic100;

import java.util.Scanner;

public class Problem29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String result = Integer.toOctalString(input);
        System.out.println(result);
    }
}
