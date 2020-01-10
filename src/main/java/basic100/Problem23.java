package basic100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        while (input != 0) {
            list.add(input % 10);
            input /= 10;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println("[" + (int) (list.get(i) * Math.pow(10, (i))) + "]");
        }
    }
}
