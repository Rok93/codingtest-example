package p20200729;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        String input;

        int count = 0;
        do {
            count++;
            input = sc.nextLine();

            if (input.contains("-")) {
                break;
            }

            while (input.contains("{}")) {
                input = input.replaceAll("\\{\\}", "");
            }

            int leftBracket = 0;
            int rightBracket = 0;
            char[] chars = input.toCharArray();
            for (char c : chars) {
                if (c == '{') {
                    leftBracket++;
                    continue;
                }
                rightBracket++;
            }

            if (leftBracket % 2 == 0) {
                System.out.println(count + ". " + ((leftBracket / 2) + (rightBracket / 2)));
                continue;
            }
            System.out.println(count + ". " + ((leftBracket / 2) + (rightBracket / 2) + 2));

        } while (true);
    }
}
/* 입력
}{
{}{}{}
{{{}
---
 */
