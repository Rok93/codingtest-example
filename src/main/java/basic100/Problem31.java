package basic100;

import java.util.Scanner;

public class Problem31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] inputs = input.toCharArray();

        int length = inputs.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += (int) (Math.pow(8, length - (i + 1)) * Integer.parseInt(String.valueOf(inputs[i])));
        }

        System.out.println(sum);
    }
}
