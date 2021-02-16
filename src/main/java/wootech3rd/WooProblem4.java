package wootech3rd;

public class WooProblem4 {

    private int n;

    public int solution(int n, int[][] board) {
        this.n = n;

        int totalNumberLength = n * n;
        int[] numbers = new int[totalNumberLength + 1];
        int[][] coordinates = new int[totalNumberLength + 1][2];
        for (int i = 1; i <= totalNumberLength; i++) {
            numbers[i] = i;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coordinates[board[i][j]][0] = i;
                coordinates[board[i][j]][1] = j;
            }
        }


        int currentX = 0;
        int currentY = 0;
        int sum = 0;
        for (int i = 1; i <= n * n; i++) {
            sum += getDistance(currentX, currentY, coordinates[i]) + 1;
            currentX = coordinates[i][0];
            currentY = coordinates[i][1];
        }

        return sum;
    }

    private int getDistance(int currentX, int currentY, int[] coordinate) {
        int targetX = coordinate[0];
        int targetY = coordinate[1];
        int minX = Math.min(n - Math.abs(targetX - currentX), Math.abs(targetX - currentX));
        int minY = Math.min(n - Math.abs(targetY - currentY), Math.abs(targetY - currentY));

        return minX + minY;
    }
}
