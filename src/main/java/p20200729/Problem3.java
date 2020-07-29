package p20200729;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tryNumber = sc.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < tryNumber; i++) {
            int inputNumber = sc.nextInt();

            if (inputNumber == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(priorityQueue.poll());
                continue;
            }
            priorityQueue.add(inputNumber);
        }
    }
}
