package p20200610;

import java.util.Arrays;
import java.util.Scanner;

public class Study4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = input.length();
        if (len <= 2) {
            System.out.println(len);
            return;
        }
        String mainInput = input.substring(1, len - 1);
        long count = Arrays.stream(mainInput.split(""))
                .distinct()
                .count();

        int gap = (int) (len - count);

        System.out.println(2 + (len * 2) - gap);
    }

}
