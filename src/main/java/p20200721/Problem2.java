package p20200721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int areaNumber = sc.nextInt();

        List<Integer> areaRequestBudget = new ArrayList<>();
        for (int i = 0; i < areaNumber; i++) {
            areaRequestBudget.add(sc.nextInt());
        }

        Collections.sort(areaRequestBudget);

        int fixedTotalBudget = sc.nextInt();

        int quaterOfTotalRequestBudget = fixedTotalBudget / 4;

        int notSatisfiedAreaBudgetNumber = 0;
        int restOfBudget = 0;

        for (int budget : areaRequestBudget) {
            int restBudgetOfThisArea = quaterOfTotalRequestBudget - budget;
            if (restBudgetOfThisArea < 0) { // 예산 만족 x
                notSatisfiedAreaBudgetNumber++;
                continue;
            }
            restOfBudget += restBudgetOfThisArea;
        }
        int plusBudget = restOfBudget / notSatisfiedAreaBudgetNumber;
        quaterOfTotalRequestBudget += plusBudget;
        System.out.println(quaterOfTotalRequestBudget);
    }
}
