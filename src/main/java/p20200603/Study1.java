package p20200603;

import java.util.Arrays;
import java.util.Scanner;

public class Study1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int Y = Integer.parseInt(temp[0]);
        int X = Integer.parseInt(temp[1]);
        int[][] tomatoes = new int[X][Y];

        for (int i = 0; i < X; i++) {
            String temp2 = sc.nextLine();
            String[] splitTemp = temp2.split(" ");
            for (int j = 0; j < Y; j++) {
                tomatoes[i][j] = Integer.parseInt(splitTemp[j]);
            }
        }

        int answer = 0;

        if (isAllTomatoBeDone(tomatoes)) { // 저장될 때부터 토마토가 익어있는 상태라면 0
            System.out.println(0);
            return;
        }

        while (true) {
            answer++;
            int[][] afterTomatos = new int[X][];
            for (int i = 0; i < X; i++) {
                afterTomatos[i] = tomatoes[i].clone();
            }

            beDoneTomato(afterTomatos, tomatoes);

            if (isAllTomatoBeDone(afterTomatos)) {
                break;
            }

            if (isEqualTo(tomatoes, afterTomatos)) {
                System.out.println("-1");
                return;
            }

            tomatoes = afterTomatos.clone();
        }
        System.out.println(answer);
    }

    private static boolean isAllTomatoBeDone(int[][] afterTomatos) {
        return Arrays.stream(afterTomatos)
                .allMatch(Study1::isBeDoneTomato);
    }

    private static boolean isBeDoneTomato(int[] n) {
        return Arrays.stream(n)
                .allMatch(number -> number == 1 || number == -1);
    }

    private static void beDoneTomato(int[][] afterTomatos, int[][] beforTomatos) {
        int X = beforTomatos.length;
        int Y = beforTomatos[0].length;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (beforTomatos[i][j] == 1) {
                    changeTomatos(afterTomatos, i, j);
                    continue;
                }
            }
        }
    }

    private static void changeTomatos(int[][] afterTomatos, int i, int j) {
        int X = afterTomatos.length;
        int Y = afterTomatos[0].length;

        if (i - 1 >= 0 && afterTomatos[i - 1][j] != -1) {
            afterTomatos[i - 1][j] = 1;
        }
        if (i + 1 <= X - 1 && afterTomatos[i + 1][j] != -1) {
            afterTomatos[i + 1][j] = 1;
        }

        if (j - 1 >= 0 && afterTomatos[i][j - 1] != -1) {
            afterTomatos[i][j - 1] = 1;
        }

        if (j + 1 <= Y - 1 && afterTomatos[i][j + 1] != -1) {
            afterTomatos[i][j + 1] = 1;
        }
    }

    private static boolean isEqualTo(int[][] before, int[][] after) {
        int xLen = before.length;

        for (int i = 0; i < xLen; i++) {
            if (!Arrays.equals(before[i], after[i])) {
                return false;
            }
        }
        return true;
    }
}
