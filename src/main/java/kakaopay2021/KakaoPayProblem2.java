package kakaopay2021;

import java.util.Arrays;

public class KakaoPayProblem2 {

    // rows X columns  크기의 행렬이 있다. 각 칸은 숫자가 들어있는 정사각형이다.
    // 행렬의 부분 직사각형을 여러 번 골라 그 내부를 `스와이프` 한다.
    // 스와이프란... 특정 영역의 숫자들을 빨간색 화살표 방향으로 밀어내고, 사라진 숫자들을 다시 빈 칸에 순서대로 채워넣는 것을 의미
    // 방향은  [1] 행번호가 증가하는 방향, [2] 행 번호가 감소하는 방향, [3] 열 번호가 증가하는 방향, [4] 열 번호가 감소하는 방향

    private static final int ROW_PLUS = 1;
    private static final int ROW_MINUS = 2;
    private static final int COLUMN_PLUS = 3;
    private static final int COLUMN_MINUS = 4;

    private static int[] answer;

    public int[] solution(int rows, int columns, int[][] swipes) {
        answer = new int[swipes.length];
        int[][] arr = new int[rows][columns];
        initArray(arr);

        int cnt = 0;
        for (int[] swipe : swipes) {
            int d = swipe[0];
            int r1 = swipe[1];
            int c1 = swipe[2];
            int[] firstPoint = {r1, c1};
            int r2 = swipe[3];
            int c2 = swipe[4];
            int[] secondPoint = {r2, c2};

            answer[cnt++] = swap(arr, firstPoint, secondPoint, d);
        }

        return answer;
    }

    private int swap(int[][] arr, int[] firstPoint, int[] secondPoint, int direction) {
        int minRow = Math.min(firstPoint[0], secondPoint[0]) - 1;
        int maxRow = Math.max(firstPoint[0], secondPoint[0]) - 1;
        int minColumn = Math.min(firstPoint[1], secondPoint[1]) - 1;
        int maxColumn = Math.max(firstPoint[1], secondPoint[1]) - 1;

        int rowLength = arr.length;
        int columnLength = arr[0].length;

        int sum = 0;
        int[][] copyArr = new int[rowLength][columnLength];
        if (direction == ROW_PLUS) { // 행이 추가! 1
            for (int column = minColumn; column <= maxColumn; column++) {
                for (int row = minRow; row <= maxRow; row++) {
                    int nextRow;

                    if (row + 1 > maxRow) {
                        if (maxRow == rowLength - 1) {
                            nextRow = (row + 1) % rowLength;
                        } else {
                            nextRow = minRow;
                        }
                        sum += arr[row][column];
                    } else {
                        nextRow = row + 1;
                    }

                    copyArr[nextRow][column] = arr[row][column];
                }
            }
        }

        if (direction == ROW_MINUS) { // 행이 감소 2
            for (int column = minColumn; column <= maxColumn; column++) {
                for (int row = minRow; row <= maxRow; row++) {
                    int nextRow;
                    if (row - 1 < minRow) {
                        if (minRow == 0) {
                            nextRow = (row + (rowLength - 1)) % rowLength;
                        } else {
                            nextRow = maxRow;
                        }
                        sum += arr[row][column];
                    } else {
                        nextRow = row - 1;
                    }

                    copyArr[nextRow][column] = arr[row][column];
                }
            }
        }

        if (direction == COLUMN_PLUS) { // 열이 추가! 3
            for (int row = minRow; row <= maxRow; row++) {
                for (int column = minColumn; column <= maxColumn; column++) {
                    int nextColumn;

                    if (column + 1 > maxColumn) {
                        if (minColumn == 0) {
                            nextColumn = (column + 1) % columnLength;
                        } else {
                            nextColumn = minColumn;
                        }
                        sum += arr[row][column];
                    } else {
                        nextColumn = column + 1;
                    }

                    copyArr[row][nextColumn] = arr[row][column];
                }
            }
        }

        if (direction == COLUMN_MINUS) { // 열이 감소 4
            for (int row = minRow; row <= maxRow; row++) {
                for (int column = minColumn; column <= maxColumn; column++) {
                    int nextColumn;

                    if (column - 1 < minColumn) {
                        if (maxColumn == columnLength - 1) {
                            nextColumn = (column + (columnLength - 1)) % columnLength;
                        } else {
                            nextColumn = maxColumn;
                        }
                        sum += arr[row][column];
                    } else {
                        nextColumn = column - 1;
                    }

                    copyArr[row][nextColumn] = arr[row][column];
                }
            }
        }

        for (int row = minRow; row <= maxRow; row++) {
            for (int column = minColumn; column <= maxColumn; column++) {
                arr[row][column] = copyArr[row][column];
            }
        }

        return sum;
    }

    private void initArray(int[][] arr) {
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = cnt++;
            }
        }
    }

    private void printArr(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

}
