package programmers.level2test;

import java.util.PriorityQueue;

public class Problem3 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heapFood = new PriorityQueue<>();
        for (int foodValue : scoville) {
            heapFood.offer(foodValue);
        }

        while (heapFood.peek() < K) {
            if (heapFood.size() == 1) {
                return -1;
            }

            int newFood = heapFood.poll() + (2 * heapFood.poll());
            heapFood.offer(newFood);
            answer++;
        }

        return answer;
    }
}
