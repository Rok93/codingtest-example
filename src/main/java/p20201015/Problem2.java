package p20201015;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {
    private static Gear[] gears;

    // 14891번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gears = new Gear[4];

        for (int i = 0; i < 4; i++) {
            List<Integer> teeth = Arrays.stream(sc.nextLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            gears[i] = new Gear(teeth);
        }

        int rotationNumber = sc.nextInt();
        for (int i = 0; i < rotationNumber; i++) {
            int gearNumber = sc.nextInt(); // 1 ~ 4 (1 감소 시켜서 생각!)
            int rotationDirection = sc.nextInt(); // 1: 시계, -1: 반시계
            int[] directions = new int[4];
            Arrays.fill(directions, -100);
            dfs(gearNumber, directions, rotationDirection);


            for (int j = 0; j < 4; j++) {
                gears[j].rotate(directions[j]);
            }
        }

        int sum = IntStream.range(0, 4)
                .map(index -> score(index + 1, gears[index]))
                .sum();

        System.out.println(sum);
    }

    private static int score(int gearNumber, Gear gear) {
        if (gear.getPoint() != 1) {
            return 0;
        }

        if (gearNumber == 1) {
            return 1;
        }

        if (gearNumber == 2) {
            return 2;
        }

        if (gearNumber == 3) {
            return 4;
        }
        return 8;
    }

    private static void dfs(int gearNumber, int[] directions, int rotationDirection) {
        if (gearNumber < 1 || gearNumber > 4) {
            return;
        }

        int currentGearNumber = gearNumber - 1;
        if (directions[currentGearNumber] != -100) { // 이미 처리가 된 부분!
            return;
        }

        directions[currentGearNumber] = rotationDirection;

        if (gearNumber > 1) {
            if (rotationDirection == 0) {
                dfs(gearNumber - 1, directions, 0);
            } else if (gears[currentGearNumber - 1].getRight() == gears[currentGearNumber].getLeft()) {
                dfs(gearNumber - 1, directions, 0);
            } else {
                dfs(gearNumber - 1, directions, rotationDirection == 1 ? -1 : 1);
            }
        }

        if (gearNumber < 4) {
            if (rotationDirection == 0) {
                dfs(gearNumber + 1, directions, 0);
            } else if (gears[currentGearNumber + 1].getLeft() == gears[currentGearNumber].getRight()) {
                dfs(gearNumber + 1, directions, 0);
            } else {
                dfs(gearNumber + 1, directions, rotationDirection == 1 ? -1 : 1);
            }
        }
    }

    public static class Gear {
        private List<Integer> teeth;

        public Gear(List<Integer> teeth) {
            this.teeth = teeth;
        }

        public int getPoint() {
            return teeth.get(0);
        }

        public int getRight() {
            return teeth.get(2);
        }

        public int getLeft() {
            return teeth.get(6);
        }

        public void rotate(int direction) {
            if (direction == 0) {
                return;
            }

            if (direction == 1) {
                rotateClockwise();
                return;
            }

            rotateCounterClockwise();
        }

        public void rotateClockwise() {
            int lastTooth = teeth.get(7);
            teeth.remove(7);
            teeth.add(0, lastTooth);
        }

        public void rotateCounterClockwise() {
            int firstTooth = teeth.get(0);
            teeth.remove(0);
            teeth.add(firstTooth);
        }
    }
}
