package basic100;

import java.util.Scanner;

// 정수형 두개의 합 --> int로 처리가 가능한지 고민할 것!
public class Problem35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input1 = sc.nextInt();
        long input2 = sc.nextInt();
        long sum = input1 + input2;
        System.out.println(sum);
    }
}
