package basic100;

import java.util.Scanner;

public class Problem42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input1 = sc.nextLong();
        long input2 = sc.nextLong();
        System.out.println(input1 + input2);
        System.out.println(input1 - input2);
        System.out.println(input1 * input2);
        System.out.println(input1 / input2);
        System.out.println(input1 % input2);
        System.out.printf("%.2f", (double)input1 / input2);
    }
}
