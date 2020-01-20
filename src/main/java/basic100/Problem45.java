package basic100;

import java.util.Scanner;

public class Problem45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.printf("%d",(a * 1<<b));
    }
}
