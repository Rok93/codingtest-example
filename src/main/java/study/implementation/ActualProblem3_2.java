package study.implementation;

public class ActualProblem3_2 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        int N = lock.length;
        int M = key.length;
        int[][] newLock = new int[3 * N][3 * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newLock[N + i][N + j] = lock[i][j];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key);
            for (int x = 0; x < N * 2; x++) {
                for (int y = 0; y < N * 2; y++) {
                    // 자물쇠에 열쇠 끼워넣기
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }

                    if (isCollect(newLock)) {
                        return true;
                    }

                    // 자물쇠에 열쇠 빼기
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }

                }
            }
        }
        return false;
    }

    private boolean isCollect(int[][] newLock) {
        int length = newLock.length / 3;
        for (int i = length; i < 2 * length; i++) {
            for (int j = length; j < 2 * length; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] rotate(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotatedArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedArr[j][n - i - 1] = arr[i][j];  // or rotatedArr[i][j] = arr[n - 1 - j][i] 로 해도 무방!
            }
        }
        return rotatedArr;
    }
}
