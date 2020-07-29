package p20200729;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean changingStatus = true;
        while (changingStatus) {
            changingStatus = false;

            if (input.contains("[]")) {
                input.replaceAll("\\[\\]", "");
                changingStatus = true;
            }

            if (input.contains("()")) {
                input.replaceAll("\\(\\)", "");
                changingStatus = true;
            }
        }
    }
}
