package n202020615;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Study3 {

    private static double X;
    private static double Y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        X = Double.parseDouble(input[0]);
        Y = Double.parseDouble(input[1]);

        int curResult = Y == 0 ? 0 : new BigDecimal(Y / X * 100).setScale(2, RoundingMode.DOWN).intValue();

        int cnt = 1;
        while (true) {
            if (getWinningRate(cnt) != curResult) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static int getWinningRate(int number) {
        return new BigDecimal((Y + number) / (X + number) * 100).setScale(0, RoundingMode.DOWN).intValue();
    }
}
