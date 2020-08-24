package study.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinNumber = sc.nextInt();
        List<Integer> monetaryUnits = new ArrayList<>();
        for (int i = 0; i < coinNumber; i++) {
            monetaryUnits.add(sc.nextInt());
        }

        Collections.sort(monetaryUnits);
        System.out.println(monetaryUnits);

        int target = 1;
        for (int monetaryUnit : monetaryUnits) {
            if (target < monetaryUnit) {
                break;
            }

            target += monetaryUnit;
        }

        System.out.println(target);
    }
}
