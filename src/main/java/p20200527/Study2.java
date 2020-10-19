package p20200527;

import java.util.Scanner;

public class Study2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] splits = sc.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(splits[j]);
            }
        }


    }
}
