package basic100;

import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float input = sc.nextFloat() * 100;
        float result = (float)Math.round(input) / 100;
        System.out.printf("%.2f",result);
    }
}
