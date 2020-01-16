package basic100;

import java.util.Scanner;

public class Problem37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        long result = (input * -1);
        System.out.println(result + " == " + -input);
        // 처음 알았다 변수앞에 -(negative) 붙이면 바로 음수형으로 표현이 되는지 !!
    }
}
