package gamadevmatching;

public class Problem1 {
    private static final char[] WORD_NUMBER = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        char[] chars = word.toCharArray();
        int sum = 0;

        for (char c : chars) {
            for (int i = 0; i < 5; i++) {
                if (c == WORD_NUMBER[i]) {
                    sum += (i + 1);
                    break;
                }
            }
        }

        if (chars.length < 5) {
            System.out.println("길이가 짧나? ");
            int addNumber = 5 - chars.length;
            sum += 5 * addNumber;
        }

        return sum;
    }
}
