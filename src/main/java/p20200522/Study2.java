package p20200522;

import java.util.Scanner;

public class Study2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tryNumber = sc.nextInt();

        int[] fibonachiArr = new int[41];
        fibonachiArr[0] = 0;
        fibonachiArr[1] = 1;
        int fibonachiArrLen = fibonachiArr.length;
        for (int i = 2; i < fibonachiArrLen; i++) {
            fibonachiArr[i] = fibonachiArr[i - 1] + fibonachiArr[i - 2];
        }

        for (int i = 0; i < tryNumber; i++) {
            int input = sc.nextInt();

            if (input == 0) {
                System.out.println("1 0");
                continue;
            }

            if (input == 1) {
                System.out.println("0 1");
                continue;
            }

            System.out.println(fibonachiArr[input - 1] + " " + fibonachiArr[input]);
        }
    }
}
