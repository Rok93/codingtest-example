package p20201224.sixshop;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public String solution(String s1, String s2) {
        if (s1.equals(s2)) {
            return s1;
        }

        List<String> answers = new ArrayList<>();
        String minStr = s1 + s2;
        answers.add(s1 + s2);
        answers.add(s2 + s1);
        for (int i = 1; i <= s1.length(); i++) {
            String substring = s1.substring(s1.length() - i);  //xyZA , AxA
            if (s2.contains(substring)) {
                String mixStr = s1.substring(0, s1.length() - i) + s2;
                if (minStr.length() > mixStr.length()) {
                    minStr = mixStr;
                    answers.add(minStr);
                    continue;
                }

                if (minStr.length() == mixStr.length()) {
                    answers.add(mixStr);
                }
            }
        }

        for (int i = 1; i <= s2.length(); i++) {
            String substring = s2.substring(s2.length() - i);  //xyZA , AxA
            if (s1.contains(substring)) {
                String mixStr = s2.substring(0, s2.length() - i) + s1;

                if (minStr.length() > mixStr.length()) {
                    minStr = mixStr;
                    answers.add(minStr);
                    continue;
                }

                if (minStr.length() == mixStr.length()) {
                    answers.add(mixStr);
                }
            }
        }

        System.out.println(answers);

        int minLength = answers.stream()
                .mapToInt(String::length)
                .min()
                .getAsInt();

        return answers.stream()
                .filter(answer -> answer.length() == minLength)
                .sorted()
                .findFirst()
                .get();
    }
}
