package basic100;

import java.util.Scanner;

public class Problem15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for(int i = 0; i < 3; i++) {
            System.out.print(input);
            if(i != 2) {
                System.out.print(" ");
            }
        }
    }
}
