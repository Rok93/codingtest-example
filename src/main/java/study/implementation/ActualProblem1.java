package study.implementation;

import java.util.Arrays;
import java.util.Scanner;

// 럭키 스트레이트
public class ActualProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String strN = String.valueOf(N);
        String beforeN = strN.substring(0, strN.length() / 2);
        int beforeSum = Arrays.stream(beforeN.split(""))
                .mapToInt(Integer::valueOf)
                .sum();
        String afterN = strN.substring(strN.length() / 2);
        int afterSum = Arrays.stream(afterN.split(""))
                .mapToInt(Integer::valueOf)
                .sum();

        String answer = beforeSum == afterSum ? "LUCKY" : "READY";
        System.out.println(answer);
    }
}
