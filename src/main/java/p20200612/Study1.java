package p20200612;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Study1 {

    private static List<String> answers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNum = Integer.parseInt(sc.nextLine());

        answers = new ArrayList<>();

        for (int i = 0; i < tryNum; i++) {
            String[] inputs = sc.next().split("");
            String strikeCnt = sc.next();
            String ballCnt = sc.next();

            if (strikeCnt.equals(3)) {
                System.out.println(1);
                return;
            }

            //모든 경우 추가!
            if (ballCnt.equals(3)) { //out! 모든 숫자 제외
                answers = answers.stream()
                        .filter(arr -> (arr.contains(inputs[0]))
                                && (arr.contains(inputs[1])
                                && (arr.contains(inputs[2]))))
                        .collect(Collectors.toList());
                continue;
            }

            findAllCase(inputs, strikeCnt, ballCnt);


        }
    }

    private static void findAllCase(String[] inputs, String strikeCnt, String ballCnt) {
        // s b

        // 1 0
        if (strikeCnt.equals(1) && ballCnt.equals(0)) {

            return;
        }
        // 2 0
        if (strikeCnt.equals(1) && ballCnt.equals(0)) {

            return;
        }
        // 1 1
        if (strikeCnt.equals(1) && ballCnt.equals(0)) {

            return;
        }
        // 2 1
        if (strikeCnt.equals(1) && ballCnt.equals(0)) {

            return;
        }
        // 1 2
        if (strikeCnt.equals(1) && ballCnt.equals(0)) {

            return;
        }
        // 0 2
        if (strikeCnt.equals(1) && ballCnt.equals(0)) {

            return;
        }

//        answers
    }
}
