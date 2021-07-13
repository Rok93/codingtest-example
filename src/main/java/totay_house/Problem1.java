package totay_house;

public class Problem1 {

    public String solution(String input) {
        char[] chars = input.toCharArray();
        int charsLength = chars.length;

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < charsLength; i++) {
            char currentChar = chars[i];
            if (Character.isLetter(chars[i]) && !sb.toString().contains(currentChar + "")) { // 문자열인 경우! && 이미 포함된 것 X
                sb.append(currentChar);
                sum += extractNumber(input, chars, i);
                for (int j = i + 2; j < charsLength; j++) {
                    System.out.println("현재: " + currentChar + " 지금 조회: " + chars[j]);
                    if (currentChar == chars[j]) {
                        sum += extractNumber(input, chars, j);
                    }
                }
                sb.append(sum);
                sum = 0;
            }
        }
        if (sum != 0) {
            sb.append(sum);
        }
        return sb.toString();
    }

    private int extractNumber(String input, char[] chars, int i) {
        int lastDigitIndex = i + 1;
        while (lastDigitIndex < chars.length && Character.isDigit(chars[lastDigitIndex])) {
            lastDigitIndex++;
        }
        String substring = input.substring(i + 1, lastDigitIndex);
        return Integer.parseInt(substring);
    }
}
