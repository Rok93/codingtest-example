package toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chars = input.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char currentChar = chars[i];

            if (currentChar == '1') {
                if (i < length - 1) {
                    char nextChar = chars[i + 1];
                    if (nextChar == '2') {
                        continue;
                    }

                    System.out.println(false);
                    return;
                }
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
