package basic100;

import java.util.Scanner;

public class Problem40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input1 = sc.nextLong();
        long input2 = sc.nextLong();
        int result = (int) (input1 % input2);
        System.out.println(result);
    }
}
