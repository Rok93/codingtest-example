package saramintest;

import java.util.Scanner;

public class Problem2 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String id = scanner.next();
        String pw1 = scanner.next();
        String pw2 = scanner.next();

        //아이디 : 1) 3글자 이상 ~ 20글자 이하의 문자열, 2) 알파벳 소문자와 숫자만을 사용
        int idLen = id.length();
        if (idLen < 3 || idLen > 20) {
            System.out.println("fail");
            return;
        }
        char[] idChars = id.toCharArray();
        for (char c : idChars) {
            if (isSmallAlphabet(c) || isNumber(c)) {
                continue;
            }
            System.out.println("fail");
            return;
        }

        //비밀번호 : 1) 8글자 이상 ~ 20글자 이하 알파벳 대/소문자, 숫자, 특수기호(!@#$)를 사용 --> 알파벳, 숫자, 특수기호가 각각 하나 이상은 반드시 사용
        int pwLen = pw1.length();
        char[] pw1Char = pw1.toCharArray();

        boolean pwNumCheck = false;
        boolean pwAlphabetCheck = false;
        boolean pwSpecialSymbolCheck = false;
        for (char c : pw1Char) {
            if (pwLen < 8 || pwLen > 20) {
                System.out.println("fail");
                return;
            }

            if (isSmallAlphabet(c)) {
                pwAlphabetCheck = true;
                continue;
            }

            if (isLargeAlphabet(c)) {
                pwAlphabetCheck = true;
                continue;
            }

            if (isNumber(c)) {
                pwNumCheck = true;
                continue;
            }

            if (isSpecialSymbol(c)) {
                pwSpecialSymbolCheck = true;
                continue;
            }

            System.out.println("fail");
            return;
        }

        if (!pwAlphabetCheck || !pwNumCheck || !pwSpecialSymbolCheck) {
            System.out.println("fail");
            return;
        }

        //비밀번호와 확인용 비밀번호는 일치해야 하며 모두 위의 비밀번호 규칙을 만족해야 한다.
        if (!pw1.equals(pw2)) { //pw1 검증이 다 되었기 때문에 다르면 무조건 fail
            System.out.println("fail");
            return;
        }
        System.out.println("pass");
    }

    private static boolean isSmallAlphabet(char c) {
        if (('a' <= c && c <= 'z')) {
            return true;
        }
        return false;
    }

    private static boolean isLargeAlphabet(char c) {
        if (('A' <= c && c <= 'Z')) {
            return true;
        }
        return false;
    }

    private static boolean isNumber(char c) {
        if (('0' <= c && c <= '9')) {
            return true;
        }
        return false;
    }

    private static boolean isSpecialSymbol(char c) {
        if ((c == '!') || (c == '@') || (c == '#') || (c == '$')) {
            return true;
        }
        return false;
    }
}
