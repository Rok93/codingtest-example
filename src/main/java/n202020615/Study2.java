package n202020615;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Study2 {

    public static final double PI = Math.PI;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        BigDecimal uclidCircle = new BigDecimal(R * R * PI).setScale(6, RoundingMode.HALF_UP);
        BigDecimal taxiCircle = new BigDecimal(R * R * 2).setScale(6, RoundingMode.HALF_UP);
        // 유클리드 기하학에서의 원의 넓이
        System.out.println(uclidCircle.doubleValue());
        // 택시 기하학에서 원의 넓이
        System.out.println(taxiCircle.doubleValue());
    }
}
