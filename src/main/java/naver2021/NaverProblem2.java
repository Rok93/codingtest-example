package naver2021;

import java.util.Arrays;

public class NaverProblem2 {
    public int[] solution(int[][] blocks) {
        // 숫자 블록으로 이루어진 피라미드!  어떤 블록의 값은 바로 아래에 맞닿아 있는 두 블록의 값을 합한 값!
        // 피라미드 일부 블록 값이 주어졌을 때 전체 피라미드 구성을 알아낸다!

        int height = blocks.length;
        if (height < 2) { // 높이가 1인 경우는 예외!
            return new int[]{blocks[0][1]};
        }

        int[][] arr = new int[height][];
        for (int i = 0; i < height; i++) { // 값 주입!
            arr[i] = new int[i + 1];

            arr[i][blocks[i][0]] = blocks[i][1];
        }


        for (int i = 1; i < height; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                find(i, j, arr);
            }
        }

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }


        int[] answer = new int[getNSum(height)];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[cnt++] = arr[i][j];
            }
        }

        //0 -> 0, 50
        //1 -> 0, 22
        //2 -> 2, 10
        //3 -> 1, 4
        //4 -> 4, -13

        return answer;
    }

    private void find(int i, int j, int[][] arr) {
        if (i >= arr.length || j >= arr[i].length) {
            return;
        }

        if (arr[i][j] == 0) {
            System.out.println("현재 i: " + i + " 현재 j: " + j);
            if (j + 1 < arr[i].length && arr[i][j + 1] == 0) {
                find(i, j + 1, arr); // 옆으로 이동하자!
            }

            if (j - 1 >= 0 && arr[i][j - 1] != 0) {
                arr[i][j] = arr[i - 1][j - 1] - arr[i][j - 1];
            }

            if (j + 1 < arr[i].length && arr[i][j + 1] != 0) {
                arr[i][j] = arr[i - 1][j] - arr[i][j + 1];
            }
        }
    }

    private int getNSum(int n) {
        return n * (n + 1) / 2;
    }
}
