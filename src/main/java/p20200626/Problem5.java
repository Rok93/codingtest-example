package p20200626;

import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {

    public static final int ARR_SIZE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNumber = sc.nextInt();

        while (tryNumber-- > 0) {
            int[] arr = new int[ARR_SIZE];
            for (int i = 0; i < ARR_SIZE; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(Arrays.stream(arr)
                    .sorted()
                    .limit(arr.length - 2)
                    .max()
                    .getAsInt()
            );
        }
    }
}
