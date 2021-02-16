package p20201020;

import java.util.Scanner;

public class Problem4 {
    // 1748
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int mock = 1;
        int sum = 0;
        while (number / (mock * 10) != 0) {
            sum += mock * 9;
            mock *= 10;
        }

        sum += (number - mock + 1) * String.valueOf(mock).length();
        System.out.println(sum);
    }
}
