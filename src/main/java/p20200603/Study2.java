package p20200603;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Study2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String[] inputX = temp.split("\\.");
        String[] inputDot = temp.split("X");

        List<String> inputXs = Arrays.asList(inputX).stream()
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());

        List<String> inputDots = Arrays.asList(inputDot).stream()
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());

        List<String> answerList = new ArrayList<>();
        for (String s : inputXs) {
            if (s.length() % 2 == 1) {
                System.out.println(-1);
                return;
            }

            answerList.add(coverUp(s));
        }

        int size = answerList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                System.out.print(inputDots.get(i - 1));
            }
            System.out.print(answerList.get(i));
        }

    }

    private static String coverUp(String s) {
        String answer = "";
        while (s.length() > 0) {
            if (s.length() >= 4) {
                answer += "AAAA";
                s = s.substring(4);
                continue;
            }

            if (s.length() >= 2) {
                answer += "BB";
                s = s.substring(2);
            }
        }
        return answer;
    }
}
