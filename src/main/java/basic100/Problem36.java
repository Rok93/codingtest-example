package basic100;

import java.util.Scanner;

public class Problem36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input1 = sc.nextLong();
        long input2 = sc.nextLong(); // 타입 다르게해도 .. 오류표시가 안뜸, 컴파일시에 발견
        long sum = input1 + input2;
        System.out.println(sum);
    }
}
