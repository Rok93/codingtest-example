package p20200522;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Study1 {
    public static void main(String[] args) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        int barLength = 64;

        while (barLength >= 1) {
            list.add(barLength);
            barLength /= 2;
        }

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= X) {
                answer++;
                X -= list.get(i);
                list.remove(i--);
            }
        }
        System.out.println(answer);
    }
}
