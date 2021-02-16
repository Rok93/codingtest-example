package wootech3rd;

public class WooProblem7 {

    private boolean horizontal;
    private int cnt;
    private int currentX;
    private int currentY;
    private int[][] answer;
    private int n;

    public int[][] solution(int n, boolean horizontal) {
        this.horizontal = horizontal; // true: 오른쪽, false: 아래쪽
        this.answer = new int[n][n];

        this.currentX = 0;
        this.currentY = 0;

        int targetX = n - 1;
        int targetY = n - 1;
        this.n = n;

        this.cnt = 0;
        int totalDiagonalNumber = (n - 1) + (n - 1);
        for (int i = 1; i <= totalDiagonalNumber; i++) {
            cnt++;
            if (this.horizontal) { // 오른쪽
                if (currentY + 1 < n) {
                    currentY++;
                } else {
                    currentX++;
                }
            } else { // 아래로!
                if (currentX + 1 < n) {
                    currentX++;
                } else {
                    currentY++;
                }
            }

            answer[currentX][currentY] = cnt;

            if (currentX == targetX && currentY == targetY) {
                break;
            }

            this.horizontal = this.horizontal ? false : true;

            playCleanDiagonalLine(i);
        }

        return answer;
    }

    private void playCleanDiagonalLine(int currentDiagonalNumber) {
        // true: 오른쪽, false: 아래쪽 (인데 반대로 전환시킴!)
        while (true) {
            cnt += 2;

            if (horizontal) {   //true 가 오른쪽 위로 이동!
                currentY++;
                currentX--;
                answer[currentX][currentY] = cnt;

                if (currentY == currentDiagonalNumber || currentY == n - 1) {
                    break;
                }
                continue;
            }

            //false 가 왼쪽 아래로 이동!
            currentY--;
            currentX++;
            answer[currentX][currentY] = cnt;

            if (currentX == currentDiagonalNumber || currentX == n - 1) {
                break;
            }
        }
    }
}
