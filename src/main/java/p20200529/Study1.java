package p20200529;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Study1 {
    private static final int CHESS_LEN = 6;

    public static void main(String[] args) {
        //행: 숫자, 열: 문자
        Map<String, Integer> Y = new HashMap<>();
        Y.put("A", 0);
        Y.put("B", 1);
        Y.put("C", 2);
        Y.put("D", 3);
        Y.put("E", 4);
        Y.put("F", 5);

        boolean[][] visited = new boolean[CHESS_LEN][CHESS_LEN];

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(""); //ex) A1
        int beforeX = Y.get(temp[0]);
        int beforeY = Integer.parseInt(temp[1]) - 1;
        visited[beforeX][beforeY] = true;

        int startX = beforeX;
        int startY = beforeY;

        for (int i = 1; i < 36; i++) {
            temp = sc.nextLine().split(""); //ex) A1
            int afterX = Y.get(temp[0]);
            int afterY = Integer.parseInt(temp[1]) - 1;

            if (!isCollectMovement(beforeX, beforeY, afterX, afterY) || visited[afterX][afterY]) {
                System.out.println("Invalid");
                return;
            }
            beforeX = afterX;
            beforeY = afterY;
            visited[afterX][afterY] = true;

            if (i == 35) {
                if (!isCollectMovement(startX, startY, afterX, afterY)) {
                    System.out.println("Invalid");
                    return;
                }
            }
        }
        System.out.println("Valid");
    }

    private static boolean isCollectMovement(int beforeX, int beforeY, int afterX, int afterY) {
        // x차이, y차이 --> 2, 1  or 1, 2 차이나야 함
        int xGap = Math.abs(beforeX - afterX);
        if (xGap > 3) xGap = 6 - xGap;

        int yGap = Math.abs(beforeY - afterY);
        if (yGap > 3) yGap = 6 - xGap;

        if (xGap == 2 && yGap == 1) return true;
        if (xGap == 1 && yGap == 2) return true;
        return false;
    }
}
