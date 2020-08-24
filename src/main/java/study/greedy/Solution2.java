package study.greedy;

import java.util.Scanner;

// 그리디문제 : 뒤집기
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split("");

        int[] continueCnt = new int[2];

        int length = inputs.length;
        String beforeNum = inputs[0];

        if (beforeNum.equals("0")) {
            continueCnt[0]++;
        } else {
            continueCnt[1]++;
        }

        for (int i = 1; i < length; i++) {
            if (inputs[i].equals(beforeNum)) {
                continue;
            }

            if (inputs[i].equals("0")) {
                continueCnt[0]++;
            } else {
                continueCnt[1]++;
            }

            beforeNum = inputs[i];
        }

        System.out.println(continueCnt[0] > continueCnt[1] ? continueCnt[1] : continueCnt[0]);

    }
}
