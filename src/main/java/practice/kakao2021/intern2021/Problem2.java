package practice.kakao2021.intern2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem2 {

    private String[] mark;
    private List<String[]> priorityRank;

    public long solution(String expression) {
        long answer = 0;

        mark = new String[]{"+", "-", "*"};
        priorityRank = new ArrayList<>();

        int[] perCheck = new int[3];
        LinkedList<String> perArr = new LinkedList<>();
        permutation(3, 3, perArr, perCheck);

        String numberFind = expression.replaceAll("\\+", " ");
        numberFind = numberFind.replaceAll("\\-", " ");
        numberFind = numberFind.replaceAll("\\*", " ");

        List<Long> numbers = new ArrayList<>();
        String[] numberStrings = numberFind.split(" ");
        for (String s1 : numberStrings) {
            numbers.add(Long.parseLong(s1));
        }

        List<String> marks = new ArrayList<>();
        char[] markStrings = expression.toCharArray();
        for (char c : markStrings) {
            if (c == '+' || c == '-' || c == '*') {
                marks.add(c + "");
            }
        }

        for (String[] s : priorityRank) {
            long sum = 0;
            List<Long> copiedNumbers = new ArrayList<>(numbers);
            List<String> copiedMarks = new ArrayList<>(marks);
            for (int i = 0; i < copiedMarks.size(); i++) {
                long calculateValue = 0;
                if (s[0].equals(copiedMarks.get(i))) { //우선순위 1
                    calculateValue += calculator(copiedNumbers.get(i), copiedNumbers.get(i + 1), s[0]);
                    copiedNumbers.set(i, calculateValue);
                    copiedNumbers.remove(i + 1);
                    copiedMarks.remove(i--);
                }
            }

            for (int i = 0; i < copiedMarks.size(); i++) {
                long calculateValue = 0;
                if (s[1].equals(copiedMarks.get(i))) { //우선순위 1
                    calculateValue += calculator(copiedNumbers.get(i), copiedNumbers.get(i + 1), s[1]);
                    copiedNumbers.set(i, calculateValue);
                    copiedNumbers.remove(i + 1);
                    copiedMarks.remove(i--);
                }
            }

            for (int i = 0; i < copiedMarks.size(); i++) {
                long calculateValue = 0;
                if (s[2].equals(copiedMarks.get(i))) { //우선순위 1
                    calculateValue += calculator(copiedNumbers.get(i), copiedNumbers.get(i + 1), s[2]);
                    copiedNumbers.set(i, calculateValue);
                    copiedNumbers.remove(i + 1);
                    copiedMarks.remove(i--);
                }
            }
            sum = Math.abs(copiedNumbers.get(0));
            answer = answer < sum ? sum : answer;
        }

        return answer;
    }

    private long calculator(Long a, Long b, String mark) {
        if (mark.equals("+")) {
            return a + b;
        }
        if (mark.equals("*")) {
            return a * b;
        }
        return a - b;
    }

    //순열 (순서있게 배열)
    private void permutation(int n, int r, LinkedList<String> perArr, int[] perCheck) {
        if (perArr.size() == r) {
            String[] temp = new String[3];
            int index = 0;
            for (String s : perArr) {
                temp[index++] = s;
            }
            priorityRank.add(temp);
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (perCheck[i] == 0) {
                perArr.add(mark[i]);
                perCheck[i] = 1;
                permutation(n, r, perArr, perCheck);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }
    }
}
