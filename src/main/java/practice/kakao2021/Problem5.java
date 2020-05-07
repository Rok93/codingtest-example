package practice.kakao2021;

import java.util.Arrays;

public class Problem5 {
    public int[] solution(String[] words, String[] queries) { //word가 멀쩡한 것 ..!
        int[] answer = Arrays.stream(queries)
                .mapToInt(query -> isMatchWord(query, words))
                .toArray();
        return answer;
    }

    private int isMatchWord(String query, String[] words) {

        boolean allQuestionMark = Arrays.stream(query.split(""))
                .allMatch(s -> s.equals("?"));

        if (allQuestionMark) {
            return words.length;
        }

        return (int) Arrays.stream(words)
                .filter(s -> isEqualTo(s, query))
                .count();
    }

    private boolean isEqualTo(String word, String query) {
        int len = word.length();
        if (query.length() != len) {
            return false;
        }

        char[] wordChars = word.toCharArray();
        char[] queryChars = query.toCharArray();

        for (int i = 0; i < len; i++) {
            if (wordChars[i] == queryChars[i] || queryChars[i] == '?') {
                continue;
            }
            return false;
        }
        return true;
    }
}
