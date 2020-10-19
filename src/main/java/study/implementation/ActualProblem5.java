package study.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 치킨 배달 : [출처] // 치킨 배달 : [출처]
public class ActualProblem5 {
    private static final int EMPTY = 0;
    private static final int HOUSE = 1;
    private static final int CHICKEN_STORE = 2;

    private static List<int[]> houses;
    private static List<int[]> chickenStores;
    private static int minChickenDistance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); // M개 남기고 폐업시킨다!

        houses = new ArrayList<>();
        chickenStores = new ArrayList<>();

        int[][] cities = new int[N][N];  // r행 c열 (r, c는 1부터 시작) 위에서 부터 r번째, 왼쪽에서부터 c번째
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int inputNumber = sc.nextInt();
                cities[i][j] = inputNumber;

                if (inputNumber == HOUSE) {
                    houses.add(new int[]{i, j});
                    continue;
                }

                if (inputNumber == CHICKEN_STORE) {
                    chickenStores.add(new int[]{i, j});
                }
            }
        }

        minChickenDistance = Integer.MAX_VALUE;

        dfs(0, new int[M], 0, M);

        System.out.println(minChickenDistance);
        // 0은 빈 칸, 1은 집, 2: 치킨집
    }

    private static void dfs(int number, int[] chickenStoreIndexs, int currentIndex, int m) {
        if (currentIndex > chickenStores.size()) {
            return;
        }

        if (number >= m) {
            List<int[]> chickenStoreList = Arrays.stream(chickenStoreIndexs.clone())
                    .mapToObj(index -> chickenStores.get(index))
                    .collect(Collectors.toList());

            int chickenDistance = getChickenDistance(houses, chickenStoreList);
            minChickenDistance = minChickenDistance > chickenDistance ? chickenDistance : minChickenDistance;
            return;
        }

        chickenStoreIndexs[number] = currentIndex;
        dfs(number + 1, chickenStoreIndexs.clone(), currentIndex + 1, m);
        dfs(number, chickenStoreIndexs.clone(), currentIndex + 1, m);
    }

    private static int getChickenDistance(List<int[]> houses, List<int[]> chickenStores) {
        return houses.stream()
                .mapToInt(house -> getMinDistance(house, chickenStores))
                .sum();
    }

    private static int getMinDistance(int[] point, List<int[]> chickenStores) {
        return chickenStores.stream()
                .mapToInt(chickenStore -> getDistance(point, chickenStore))
                .min()
                .getAsInt();
    }

    private static int getDistance(int[] point, int[] chickenStore) {
        return Math.abs(point[0] - chickenStore[0]) + Math.abs(point[1] - chickenStore[1]);
    }
}
