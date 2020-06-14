package n20200605;

import java.util.Scanner;

public class Study3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int size;
        if (input < 2) {
            size = 2;
        } else {
            size = input;
        }
        int[] arr = new int[size + 1];
        arr[1] = 1;
        arr[2] = 2;


        for (int i = 3; i < size + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
        }
        System.out.println(arr[input]);
    }
}
