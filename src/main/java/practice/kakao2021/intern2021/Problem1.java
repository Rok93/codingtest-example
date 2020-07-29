package practice.kakao2021.intern2021;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    private Map<String, int[]> keypadIndex;
    private int[] leftHand;
    private int[] rightHand;

    public String solution(int[] numbers, String hand) {
        String[][] keypad = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"*", "0", "#"}
        };

        keypadIndex = new HashMap<>();
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                keypadIndex.put(keypad[i][j], new int[]{i, j}); //좌표를 집어 넣는다!
            }
        }

        StringBuilder answer = new StringBuilder();

        leftHand = keypadIndex.get("*");
        rightHand = keypadIndex.get("#");

        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int number = numbers[i];
            String key = String.valueOf(number);

            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftHand = keypadIndex.get(key);
                continue;
            }

            if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightHand = keypadIndex.get(key);
                continue;
            }

            answer.append(compareDistance(number, hand));
        }

        return answer.toString();
    }

    private String compareDistance(int i, String hand) {
        String key = String.valueOf(i);
        int leftDistance = getDistance(leftHand, i);
        int rightDistance = getDistance(rightHand, i);

        if (leftDistance > rightDistance) {
            rightHand = keypadIndex.get(key);
            return "R";
        }

        if (leftDistance < rightDistance) {
            leftHand = keypadIndex.get(key);
            return "L";
        }

        if (hand.equals("right")) {
            rightHand = keypadIndex.get(key);
            return "R";
        }

        if (hand.equals("left")) {
            leftHand = keypadIndex.get(key);
            return "L";
        }

        return "O";
    }

    private int getDistance(int[] hand, int i) {
        String key = String.valueOf(i);
        int[] targetIndex = keypadIndex.get(key);
        int xDistacne = Math.abs(targetIndex[0] - hand[0]);
        int yDistacne = Math.abs(targetIndex[1] - hand[1]);

        return xDistacne + yDistacne;
    }
}
