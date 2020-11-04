package wootech1st20201101;

public class Problem7 {
    public String solution(String cryptogram) {
        String before = cryptogram;
        while (true) {
            int length = cryptogram.length();
            for (int i = 0; i < length - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    String temp = "";
                    temp += cryptogram.substring(0, i);
                    temp += cryptogram.substring(i + 2);
                    cryptogram = temp;
                    break;
                }
            }

            if (before.equals(cryptogram)) {
                return cryptogram;
            }

            before = cryptogram;
        }
    }
}
