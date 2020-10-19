package p20200601;

import java.util.Arrays;
import java.util.Scanner;

public class Study3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] wirds = new int[Integer.parseInt(sc.nextLine())][2];
        int len = wirds.length;

        for (int i = 0; i < len; i++) {
            String temp = sc.nextLine();
            String[] numbers = temp.split(" ");
            wirds[i] = new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])};
        }

        int[] duplicationNum = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (isCrossed(wirds[i], wirds[j])) {
                    duplicationNum[i]++;
                    continue;
                }
            }
        }

        int[] sortedDuplicationNum = Arrays.stream(duplicationNum.clone())
                .sorted()
                .toArray();

        boolean[] cutWird = new boolean[len];

        while (true) {
            if (isAllWiresNotDuplication(wirds, cutWird)) {
                break;
            }

            for (int i = 0; i < len; i++) {
                if (cutWird[i]) {
                    duplicationNum[i] = 0;
                }
            }

            for (int i = 0; i < len; i++) {
                if (duplicationNum[i] == sortedDuplicationNum[len - cutWiredNumber(cutWird) - 1]) { //제일 겹치는게 많은 전깃줄 제거하기 !
                    cutWird[i] = true;
                    wirds[i] = new int[]{0, 0};
                    break;
                }
            }
        }
        int answer = cutWiredNumber(cutWird);
        System.out.println(answer);
    }

    private static int cutWiredNumber(boolean[] cutWird) {
        int len = cutWird.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (cutWird[i]) {
                count++;
            }
        }
        return count;
    }

    private static boolean isAllWiresNotDuplication(int[][] wirds, boolean[] cutwird) {
        int len = wirds.length;
        for (int i = 0; i < len; i++) {
            if (cutwird[i]) continue;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (isCrossed(wirds[i], wirds[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCrossed(int[] wird1, int[] wird2) { //두 선을 비교하여 꼬이는지 확인!
        if (wird1[0] > wird2[0] && wird1[1] < wird2[1]) { //같은 위치에 두 개 이상의 전깃줄이 연결될 수는 없음 (= 의 경우 X)
            return true;
        }

        if (wird1[0] < wird2[0] && wird1[1] > wird2[1]) {
            return true;
        }
        return false;
    }
}
