package p20200713;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCaseNum; i++) {
            String[] inputs = sc.nextLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            System.out.println(pow(a,b));
        }
    }

    private static int pow(int a, int b) {
        int value = 1;
        for (int i = 0; i < b; i++) {
            value *= a;
            value %= 10;
        }
        return value != 0 ? value : 10;
    }
}
