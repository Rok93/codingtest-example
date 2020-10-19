package basic100;

import java.util.Scanner;

public class Problem20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] charList;
        if (input.length() > 2001) {
            charList = new char[2001];
        } else {
            charList = new char[input.length()];
        }

        for (int i = 0; i < charList.length; i++) {
            charList[i] = input.charAt(i);
        }
        System.out.println(charList);
    }
}
