package p20201013;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem3 {
    // 1966번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNumber= sc.nextInt();

        for (int i = 0; i < testNumber; i++) {
            Queue<Print> prints = new LinkedList<>();
            int totalPrintNumber = sc.nextInt();
            int targetIndex = sc.nextInt();

            int number = 0; // 몇번째로 출력이 되는가!?

            for (int j = 0; j < totalPrintNumber; j++) {
                prints.offer(new Print(j, sc.nextInt()));
            }

            while (!prints.isEmpty()) {
                int maxImportance = prints.stream()
                        .mapToInt(Print::getImportance)
                        .max()
                        .getAsInt();

                doPrint(prints, maxImportance);
                number++;

                boolean result = prints.stream()
                        .noneMatch(print -> print.isEqualToIndex(targetIndex));

                if (result) {
                    System.out.println(number);
                    break;
                }
            }
        }
    }

    private static void doPrint(Queue<Print> prints, int targetImportance) {
        while (true) {
            Print currentPrint = prints.poll();

            if (currentPrint.getImportance() == targetImportance) {
                break;
            }

            prints.offer(currentPrint); // 뒤로 보낸다!
        }
    }

    public static class Print {
        private final int index;
        private final int importance;

        public Print(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }

        public int getIndex() {
            return index;
        }

        public int getImportance() {
            return importance;
        }

        public boolean isEqualToIndex(int index) {
            return this.index == index;
        }
    }
}
