package woo2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem1Test {
        @DisplayName("우테코 2기 1번문제 풀이 ")
        @Test
        public void test() {
            Problem1 sol = new Problem1();
            int[] restaurant = new int[]{0, 0};
            int[][] riders = new int[][]{{-700, 0}, {150, 180}, {500, 500}, {150, -800}, {800, 800}, {-900, 500},
                    {-1100, 900}};
            int k = 1000;
            int answer = sol.solution(restaurant, riders, k);
            Assertions.assertEquals(4, answer);
        }
}
