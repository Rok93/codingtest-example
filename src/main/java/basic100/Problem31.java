package basic100;

import java.util.Scanner;

public class Problem31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String result = Integer.toHexString(input);
        System.out.println(result.toUpperCase());
    }
}
