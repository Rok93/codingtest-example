package p20201224.sixshop;

import java.util.*;

public class Problem4 {
    public int[] solution(int N, int[] coffee_times) {
        CoffeMachin coffeMachin = new CoffeMachin(N);

        int coffeeNumber = coffee_times.length;

        Queue<Coffee> coffees = new LinkedList<>();
        for (int sequence = 0; sequence < coffeeNumber; sequence++) {
            coffees.offer(new Coffee(sequence + 1, coffee_times[sequence]));
        }

        List<Integer> list = new ArrayList<>();

        while (coffeMachin.isMovable() || !coffees.isEmpty()) {

            while (!coffeMachin.isFull() && !coffees.isEmpty()) {
                coffeMachin.addSchedule(coffees.poll());
            }

            coffeMachin.nextTime();

            List<Coffee> completedCoffee = coffeMachin.getCompletedCoffee();
            completedCoffee.stream()
                    .map(Coffee::getSequence)
                    .sorted()
                    .forEach(sequence -> list.add(sequence));
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public class CoffeMachin {
        private final int capacity;
        private final PriorityQueue<Coffee> workSchedule;

        public CoffeMachin(int capacity) {
            this.capacity = capacity;
            this.workSchedule = new PriorityQueue();
        }

        public void addSchedule(Coffee coffee) {
            workSchedule.offer(coffee);
        }

        public void nextTime() {
            workSchedule.stream()
                    .forEach(Coffee::nextTime);
        }

        public boolean isFull() {
            return workSchedule.size() == capacity;
        }

        public List<Coffee> getCompletedCoffee() {
            List<Coffee> completedCoffees = new ArrayList<>();
            while (!workSchedule.isEmpty() && workSchedule.peek().isComplete()) {
                completedCoffees.add(workSchedule.poll());
            }

            return completedCoffees;
        }

        public boolean isMovable() {
            return !workSchedule.isEmpty();
        }

    }

    public class Coffee implements Comparable<Coffee> {
        private int sequence;
        private int makingTime;

        public Coffee(int sequence, int makingTime) {
            this.sequence = sequence;
            this.makingTime = makingTime;
        }

        public int getSequence() {
            return sequence;
        }

        public void nextTime() {
            if (this.makingTime > 0) {
                makingTime--;
            }
        }

        public boolean isComplete() {
            return makingTime == 0;
        }

        @Override
        public int compareTo(Coffee o) {
            if (this.makingTime < o.makingTime) {
                return -1;
            }
            return 1;
        }
    }
}
