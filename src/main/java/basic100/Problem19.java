package basic100;

import java.util.Scanner;

public class Problem19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] charList = new char[input.length()];

        for (int i = 0; i < charList.length; i++) {
            charList[i] = input.charAt(i);
        }
        System.out.println(charList);
    }
}
