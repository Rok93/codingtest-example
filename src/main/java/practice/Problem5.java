package practice;

public class Problem5 {
    public String solution(String s, int n) {
        String[] alphabetL = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] alphabetS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String answer = "";

        char[] sChars = s.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] >= 'a' && sChars[i] <= 'z') {
                n = n % alphabetL.length;
                for (int j = 0; j < n; j++) {
                    if (sChars[i] == 'z') {
                        sChars[i] = 'a';
                        continue;
                    }
                    sChars[i]++;
                }
            }

            if (sChars[i] >= 'A' && sChars[i] <= 'Z') {
                n = n % alphabetS.length;
                for (int j = 0; j < n; j++) {
                    if (sChars[i] == 'Z') {
                        sChars[i] = 'A';
                        continue;
                    }
                    sChars[i]++;
                }
            }
            answer += sChars[i];
        }
        return answer;
    }

    public static void main(String[] args) {
    }
}
