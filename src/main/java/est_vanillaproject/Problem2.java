package est_vanillaproject;

public class Problem2 {
    private int minValue = Integer.MAX_VALUE;
    private int scoresLength;
    private int[][] graph;

    public int solution(int[] scores, int k) {
        scoresLength = scores.length;
        graph = new int[scoresLength][scoresLength];

        for (int i = 0; i < scoresLength; i++) {
            for (int j = i + 1; j < scoresLength; j++) {
                graph[i][j] = scores[j] - scores[i];
            }
        }

        int startIndex = 0;

        dfs(k, startIndex, 0, 0);

        return minValue;
    }

    private void dfs(int k, int startIndex, int currentIndex, int sum) {
        if (sum > minValue) { // 사실상 의미없는 연산이므로 효율성을 위해 빨리 종료시킨다
            return;
        }

        if (k < 0) { // 집합이 아직 덜 나뉜경우
            return;
        }

        if (currentIndex >= scoresLength) {
            if (k > 0) { // 집합이 제대로 나뉘지 않은 경우!
                return;
            }

            int totalValue = sum;
            if (startIndex < scoresLength) {
                totalValue += graph[startIndex - 1][scoresLength - 1];
            }

            // 의도한 경우!
            minValue = minValue > totalValue ? totalValue : minValue;
            System.out.println(minValue);
            return;
        }

        dfs(k - 1, currentIndex + 1, currentIndex + 1, sum + graph[startIndex][currentIndex]); // 하나의 집합으로 보는 경우!
        dfs(k, startIndex, currentIndex + 1, sum);
    }
}
