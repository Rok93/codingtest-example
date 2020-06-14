package p20200612;

import java.util.Arrays;
import java.util.Scanner;

public class Study2 {
    public static void main(String[] args) {
        // P 일중에 L일동안만 사용 가능 V일 휴가일 때 최대 경우의 수는?
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        while (true) {
            cnt++;
            String[] input = sc.nextLine().split(" "); // L P V 순
            int L = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int V = Integer.parseInt(input[2]);

            if (L == 0 && P == 0 && V == 0) { // 종료 시점
                return;
            }

            int share = V / P;
            int rest = V % P > L ? L : V % P;
            int useDay = share * L + rest;
            System.out.println("Case " + cnt + ": " + useDay);
        }
    }
}
