package p20201104;

import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] chars = s.toCharArray();

        boolean tag = false;
        StringBuilder sb = new StringBuilder();
        String sub = "";
        for (char c : chars) {
            if (c == '>') {
                sb.append(c);
                tag = false;
                continue;
            }

            if (tag) {
                sb.append(c);
                continue;
            }

            if (c == '<') {
                sb.append(sub);
                sub = "";

                sb.append(c);
                tag = true;
                continue;
            }


            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) {
                sub = c + sub;
                continue;
            }

            sb.append(sub);
            sub = "";
            sb.append(c);
        }
        sb.append(sub);

        System.out.println(sb.toString());
    }
}
