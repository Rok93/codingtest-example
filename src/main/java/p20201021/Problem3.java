package p20201021;

import java.util.*;
import java.util.stream.Collectors;

public class Problem3 {
    private static final int RECTANGLE_SIDE_LENGTH = 10;

    // 2563번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        // 가로, 세로 길이가 각 각 100인 정사각형 !
        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            rectangles.add(new Rectangle(sc.nextInt(), sc.nextInt()));
        }

        rectangles = rectangles.stream()
                .distinct()
                .collect(Collectors.toList());

        int sum = rectangles.size() * RECTANGLE_SIDE_LENGTH * RECTANGLE_SIDE_LENGTH;

        if (rectangles.size() == 1) {
            System.out.println(100);
            return;
        }

        for (int i = 0; i < number - 1; i++) {
            for (int j = i + 1; j < number; j++) {
                // 면적 겹치는 넓이 찾는 로직
                sum -= calculateDuplicateArea(rectangles, i, j);
            }
        }

        System.out.println(sum);
    }

    private static int calculateDuplicateArea(List<Rectangle> rectangles, int i, int j) {
        Rectangle rectangleA = rectangles.get(i);
        Rectangle rectangleB = rectangles.get(j);
        int rowDifference = Math.abs(rectangleA.getX() - rectangleB.getX());
        int heightDifference = Math.abs(rectangleA.getY() - rectangleB.getY());

        if (rowDifference < RECTANGLE_SIDE_LENGTH && heightDifference < RECTANGLE_SIDE_LENGTH) {
            return (RECTANGLE_SIDE_LENGTH - rowDifference) * (RECTANGLE_SIDE_LENGTH - heightDifference);
        }

        return 0;
    }

    public static class Rectangle {
        private final int x;
        private final int y;

        public Rectangle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rectangle rectangle = (Rectangle) o;
            return x == rectangle.x &&
                    y == rectangle.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
