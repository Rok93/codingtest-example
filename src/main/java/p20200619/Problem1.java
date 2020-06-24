package p20200619;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNumber = Integer.parseInt(sc.nextLine());

        while (tryNumber > 0) {
            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                String[] numbers = sc.nextLine().split(" ");
                int x = Integer.parseInt(numbers[0]);
                int y = Integer.parseInt(numbers[1]);

                if (xList.contains(x)) {
                    xList.remove(new Integer(x));
                } else {
                    xList.add(x);
                }

                if (yList.contains(y)) {
                    yList.remove(new Integer(y));
                } else {
                    yList.add(y);
                }
            }
            if (xList.size() != 0 || yList.size() != 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            tryNumber--;
        }
    }
}
