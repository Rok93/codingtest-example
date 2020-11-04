package wootech1st20201101;

public class Problem3 {
    public String solution(String word) {
        char[] words = word.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : words) {
            sb.append(changeWord(c));
        }

        return sb.toString();
    }

    private char changeWord(char c) {
        if ('a' <= c && c <= 'z') {
            return (char)('z' - (c - 'a'));
        }

        if ('A' <= c && c <= 'Z') {
            return (char)('Z' - (c - 'A'));
        }

        return c;
    }
}
