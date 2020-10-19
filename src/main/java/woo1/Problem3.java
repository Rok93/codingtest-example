package woo1;

public class Problem3 {

    public static final int ALPHABET_TOTAL_NUMBER = 26;
    public static final char ALPHABET_SMALL_LETTER_BASE = 'a';
    public static final char ALPHABET_LARGE_LETTER_BASE = 'A';

    public String solution(String word) {
        char[] chars = word.toCharArray();
        StringBuilder answer = new StringBuilder();

        int length = chars.length;
        for (int i = 0; i < length; i++) {
            answer.append(translateChar(chars[i]));
        }

        return answer.toString();
    }

    private char translateChar(char c) {
        if ('a' <= c && c <= 'z') { // 알파벳 총 26개
            return (char) (ALPHABET_TOTAL_NUMBER + ALPHABET_SMALL_LETTER_BASE - (c - ALPHABET_SMALL_LETTER_BASE) - 1);
        }

        if ('A' <= c && c <= 'Z') {
            return (char) (ALPHABET_TOTAL_NUMBER + ALPHABET_LARGE_LETTER_BASE - (c - ALPHABET_LARGE_LETTER_BASE) - 1);
        }

        return c;
    }
}
