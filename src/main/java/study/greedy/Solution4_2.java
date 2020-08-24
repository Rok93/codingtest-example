package study.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int adventurerNumber = sc.nextInt();
        int[] fearValues = new int[adventurerNumber];

        for (int i = 0; i < adventurerNumber; i++) {
            fearValues[i] = sc.nextInt();
        }

        Arrays.sort(fearValues);

        int groupCnt = 0;
        int numberOfGroupMember = 0;
        for (int fearValue : fearValues) {
            numberOfGroupMember++;
            if (numberOfGroupMember >= fearValue) {
                groupCnt++;
                numberOfGroupMember = 0;
            }
        }

        System.out.println(groupCnt);
    }
}
