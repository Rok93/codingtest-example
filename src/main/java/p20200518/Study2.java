package p20200518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Study2 {
    private static final String[] POSITION_INDEX = {"A", "B", "C", "D", "E", "F"};
    private static final int CHESS_POSITION_NUMBER = 36;

    private static boolean[][] visitedPosition = new boolean[6][6];

    public static void main(String[] args) throws IOException {
        List<String> positions = new ArrayList<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

        for (int i = 0; i < CHESS_POSITION_NUMBER; i++) {
            positions.add(bf.readLine());
        }

        for (int i = 0; i < positions.size() - 1; i++) {
            if (isRightMovement(positions.get(i), positions.get(i + 1))) {
                continue;
            }
            System.out.println("Invalid");
            return;
        }

        if (!isRightGap(getPosition(positions.get(0)), getPosition(positions.get(35)))) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }

    private static boolean isRightMovement(String beforePosition, String nextPosition) {
        int[] before = getPosition(beforePosition);
        int[] next = getPosition(nextPosition);

        if (visitedPosition[before[0]][before[1]] || visitedPosition[next[0]][next[1]]) { //하나라도 방문한 곳이라면
            return false;
        }

        //방문한 위치로 변경
        visitedPosition[before[0]][before[1]] = true;
        if (isRightGap(before, next)) {
            return true;
        }
        return false;
    }

    private static boolean isRightGap(int[] before, int[] next) {
        int xGap = Math.abs(before[0] - next[0]);
        if (xGap > 2) {
            xGap = 6 - xGap;
        }

        int yGap = Math.abs(before[1] - next[1]);
        if (yGap > 2) {
            yGap = 6 - yGap;
        }

        if (xGap > 2 || yGap > 2) {
            return false;
        }
        return (xGap + yGap) == 3;
    }

    private static int[] getPosition(String position) {
        String[] positions = position.split(""); //ex) A1
        String xValue = positions[0];
        int x = -1;
        for (int i = 0; i < POSITION_INDEX.length; i++) {
            if (POSITION_INDEX[i].equals(xValue)) {
                x = i;
                break;
            }
        }
        int y = Integer.parseInt(positions[1]) - 1;

        return new int[]{x, y};
    }
}