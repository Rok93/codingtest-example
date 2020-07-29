package p20200527;

import java.util.Scanner;

//효율성 해결 x
public class Study1 {
    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tempSplit = sc.nextLine().split(" "); // N(표의 크기), M(합을 구해야 하는 횟수)
        int size = Integer.parseInt(tempSplit[0]);
        int tryNumber = Integer.parseInt(tempSplit[1]);

        arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] input = sc.nextLine().split(" ");
            int inputLen = input.length;
            for (int j = 0; j < inputLen; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < tryNumber; i++) {
            String[] input = sc.nextLine().split(" ");
            int[] arr1 = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
            int[] arr2 = {Integer.parseInt(input[2]), Integer.parseInt(input[3])};

            System.out.println(sumArr(arr1, arr2));
        }
    }

    private static int sumArr(int[] arr1, int[] arr2) {
        int xSmall = arr1[0] - 1;
        int xLarge = arr2[0] - 1;
        int ySmall = arr1[1] - 1;
        int yLarge = arr2[1] - 1;

        int sum = 0;
        for (int i = xSmall; i <= xLarge; i++) {
            for (int j = ySmall; j <= yLarge; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
