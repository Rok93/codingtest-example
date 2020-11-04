package p20201104;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1 {
    // 11286번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<AbsNumber> absNumbers = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int inputNumber = sc.nextInt();
            if (inputNumber == 0) {
                if (absNumbers.isEmpty()) {
                    System.out.println(0);
                    continue;
                }

                System.out.println(absNumbers.poll().getNumber());
                continue;
            }

            absNumbers.offer(new AbsNumber(inputNumber));
        }
    }

    public static class AbsNumber implements Comparable<AbsNumber> {
        private final int number;

        public AbsNumber(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int compareTo(AbsNumber o) {
            if (Math.abs(number) < Math.abs(o.number)) {
                return -1;
            }

            if (Math.abs(number) > Math.abs(o.number)) {
                return 1;
            }

            return number - o.number;
        }
    }
}
