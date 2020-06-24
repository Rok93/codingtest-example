package p20200617;

import java.util.LinkedList;
import java.util.Scanner;

public class Study1 {
    private static int N;
    private static int M;
    private static LinkedList<Integer> rePerArr;
    private static StringBuilder result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        result = new StringBuilder();
//중복순열 (순서있게 배열 + 자시자신도 포함)
        rePerArr = new LinkedList<>();
        rePermutation(0);
        System.out.println(result.toString());
    }

    //중복순열 (순서있게 배열 + 자시자신도 포함)
    private static void rePermutation(int current) {
        if (rePerArr.size() == M) {
            if (isAsc(rePerArr)) {
                for (int i : rePerArr) {
                    result.append(i + " ");
                }
                result.append("\n");
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            rePerArr.add(i);
            rePermutation(current);
            rePerArr.removeLast();
        }
    }

    private static boolean isAsc(LinkedList<Integer> rePerArr) {
        int len = rePerArr.size();
        if (len <= 1) {
            return true;
        }

        int curNum = rePerArr.get(0);
        for (int i = 1; i < len; i++) {
            int nextNym = rePerArr.get(i);
            if (curNum > nextNym) {
                return false;
            }
            curNum = nextNym;
        }
        return true;
    }
}
