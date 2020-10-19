package study.implementation;

// 문제 출처: https://programmers.co.kr/learn/challenges
// 답 출처: https://github.com/ndb796/python-for-coding-test/blob/master/12/4.java
public class ActualProblem3 {
    public boolean solution(int[][] key, int[][] lock) {
        // 자물쇠의 크기를 3배로 변환한다!
        int n = lock.length;
        int m = key.length;
        // 자물쇠의 크기를 기존의 3배로 변환
        int[][] newLock = new int[n * 3][n * 3];
        // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateKey(key); // 열쇠 회전
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    // 자물쇠에 열쇠를 끼워 넣기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }
                    // 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
                    if (check(newLock)) return true;
                    // 자물쇠에서 열쇠를 다시 빼기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    // 자물쇠의 중간 부분이 모두 1인지 확인
    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] rotateKey(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n - 1 - j][i];
            }
        }

        return rotate;
    }
}
