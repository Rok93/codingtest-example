package practice.kakao2021;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public int solution(String s) {

        if (s.length() == 1) {
            return 1;
        }

        List<String> answers = new ArrayList<>();
        int sLength = s.length();
        for (int i = 0; i < sLength / 2; i++) {
            answers.add(generateCompressString(s, i + 1));
        }

        System.out.println(answers);

        return answers.stream()
                .mapToInt(String::length)
                .min()
                .getAsInt();
    }

    private String generateCompressString(String s, int number) {
        int length = (int) Math.ceil(s.length() / (double) number);
        String[] arr = new String[length];
        String copiedS = s;
        for (int i = 0; i < length; i++) {
            if (copiedS.length() >= number) {
                arr[i] = copiedS.substring(0, number); // 0 * 1, 1
            } else {
                arr[i] = copiedS;
                break;
            }
            copiedS = copiedS.substring(number);
        }

        int arrLength = arr.length;
        int cnt = 1;
        StringBuilder generatedString = new StringBuilder();
        String standard = "";
        for (int i = 0; i < arrLength; i++) {
            if (i == 0) {
                standard = arr[i];
                continue;
            }

            if (standard.equals(arr[i])) {
                cnt++;
                continue;
            }

            if (cnt != 1) {
                generatedString.append(cnt);
            }
            generatedString.append(standard);
            // 기준 변경, cnt
            cnt = 1;
            standard = arr[i];
        }

        if (cnt != 1) {
            generatedString.append(cnt);
        }
        generatedString.append(standard);

        return generatedString.toString();
    }
}
