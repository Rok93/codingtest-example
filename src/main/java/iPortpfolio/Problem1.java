package iPortpfolio;

public class Problem1 {
    public int solution(String plain) {
        int len = plain.length();
        int i = len;

        while (true) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if ((i - j - 1) >= len) {
                    continue;
                }

                if (plain.charAt(j) != plain.charAt(i - j - 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;

            i++;
        }
    }
}
