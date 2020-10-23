package p20201021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem6 {
    // 7568번 덩치
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();
            peoples.add(new People(weight, height));
        }

        for (int i = 0; i < N; i++) {
            int rate = 1;
            People people1 = peoples.get(i);
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                People people2 = peoples.get(j);

                if (people1.isSmallerThan(people2)) {
                    rate++;
                    continue;
                }
            }
            people1.setRate(rate);
        }

        peoples.stream()
                .mapToInt(People::getRate)
                .forEach(rate -> System.out.print(rate + " "));
    }

    public static class People {
        private final int weight;
        private final int height;
        private int rate;

        public People(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        public boolean isBiggerThan(People other) {
            return other.weight < weight && other.height < height;
        }

        public boolean isSmallerThan(People other) {
            return other.weight > weight && other.height > height;
        }

    }
}
