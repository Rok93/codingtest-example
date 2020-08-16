package p20200811;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
    private boolean[] visited;
    private List<int[]> answerList;

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks); //오름차순 정렬
        this.answerList = new ArrayList<>();
        this.visited = new boolean[rocks.length];
        dfs(rocks, 0, n, 0);

        return answerList.stream()
                .mapToInt(numbers -> minDistance(numbers, distance))
                .max()
                .getAsInt();
    }

    private void dfs(int[] rocks, int currentIndex, int n, int cnt) {
        if (currentIndex == rocks.length) {
            return;
        }

        if (n == cnt) {
            int length = rocks.length;
            int[] arr = new int[length - n];
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (!visited[i]) {
                    arr[count++] = rocks[i];
                }
            }
            answerList.add(arr);
            return;
        }

        visited[currentIndex] = true;
        dfs(rocks, currentIndex + 1, n, cnt + 1);
        visited[currentIndex] = false;
        dfs(rocks, currentIndex + 1, n, cnt);
    }

    private int minDistance(int[] arr, int distance) {
        int length = arr.length;
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                minNumber = arr[i] - 0;
                continue;
            }

            int gap = arr[i] - arr[i - 1];
            minNumber = minNumber > gap ? gap : minNumber;
        }

        int lastIndex = length - 1;
        minNumber = minNumber > distance - arr[lastIndex] ? distance - arr[lastIndex] : minNumber;

        return minNumber;
    }
}
