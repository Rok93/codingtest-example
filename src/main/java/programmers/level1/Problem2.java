package programmers.level1;

import java.util.ArrayList;
import java.util.List;

// [2020카카오공채] 문자열 압축
public class Problem2 {
    public int solution(String s) {

        if(s.length() == 1) {
            return 1;
        }

        List<String> answerList = new ArrayList<>();
        for (int i = 1; i < s.length() / 2 + 1; i++) { //길이의 반이상 가봤자 축약 불가능
            tryCompress(s, i, answerList);
        }

        return answerList.stream()
                .mapToInt(String::length)
                .min()
                .getAsInt();
    }

    private void tryCompress(String s, int number, List<String> answerList) {

        String temp = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            temp += s.charAt(i);
            if (i % number == (number - 1) || i == s.length() - 1) {
                list.add(temp);
                temp = "";
            }
        }

        String compressString = "";

        while (list.size() != 0) {
            long cnt = list.stream()
                    .takeWhile(str -> str.equals(list.get(0)))
                    .count();

            if (cnt != 1) {
                compressString += cnt;
            }
            compressString += list.get(0);

            for (int i = 0; i < cnt; i++) {
                list.remove(0);
            }
        }

        answerList.add(compressString);
    }

    public static void main(String[] args) {
        Problem2 sol = new Problem2();

//        String s1 = "aabbaccc"; //2a2ba3c
//        System.out.println(sol.solution(s1)); //7
//        String s2 = "ababcdcdababcdcd";
//        System.out.println(sol.solution(s2)); //9
//        String s3 = "abcabcdede";
//        System.out.println(sol.solution(s3)); //8
//        String s4 = "abcabcabcabcdededededede";
//        System.out.println(sol.solution(s4)); //14
//        String s5 = "xababcdcdababcdcd";
//        System.out.println(sol.solution(s5)); //17

        String s6 = "s";
        System.out.println(sol.solution(s6));

    }
}
