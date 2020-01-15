package basic100;

import java.util.Scanner;

public class Problem32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] inputs = input.toCharArray();

        int length = inputs.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int value;
            if (inputs[i] == 'a') {
                value = 10;
            } else if (inputs[i] == 'b') {
                value = 11;
            } else if (inputs[i] == 'c') {
                value = 12;
            } else if (inputs[i] == 'd') {
                value = 13;
            } else if (inputs[i] == 'e') {
                value = 14;
            } else if (inputs[i] == 'f') {
                value = 15;
            } else {
                value = Character.getNumericValue(inputs[i]);
            }
            sum += (int) (Math.pow(16, length - (i + 1)) * Integer.parseInt(String.valueOf(value)));
        }

        String result = Integer.toOctalString(sum);
        System.out.println(result);
    }
}
