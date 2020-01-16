package basic100;

import java.util.Scanner;

public class Problem41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        long nextNumber = ++input;
        System.out.println(nextNumber);
    }
}
