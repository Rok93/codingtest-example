package practice.kakao2021;

public class Problem3 {
    public static final int ROTATION_NUMBER = 4;
    private int lockStartIndex;
    private int lockEndIndex;

    public boolean solution(int[][] key, int[][] lock) {
        int[][] expandedLock = generateExpandedArray(lock);

        lockStartIndex = lock.length;
        lockEndIndex = expandedLock.length - lock.length;

        for (int r = 0; r < ROTATION_NUMBER; r++) {

            int to = expandedLock.length - key.length;
            for (int i = 0; i <= to; i++) {
                for (int j = 0; j <= to; j++) {
                    //key 삽입
                    int x = 0;
                    int y;
                    for (int k = i; k < key.length + i; k++) {
                        y = 0;
                        for (int l = j; l < key.length + j; l++) {
                            expandedLock[k][l] += key[x][y++];
                        }
                        x++;
                    }

                    if (isFit(expandedLock)) {
                        return true;
                    }
                    expandedLock = generateExpandedArray(lock);
                }
            }
            key = rotateArray(key);
        }
        return false;
    }

    private boolean isFit(int[][] expandedLock) {
        for (int i = lockStartIndex; i < lockEndIndex; i++) {
            for (int j = lockStartIndex; j < lockEndIndex; j++) {
                if (expandedLock[i][j] != 1) return false;
            }
        }
        return true;
    }

    private int[][] generateExpandedArray(int[][] lock) { //길이를 3배로 확장한 새로운 배열을 만든다.
        int len = lock.length * 3;
        int[][] expandedArray = new int[len][len];
        int x = 0;
        int y;
        for (int i = len / 3; i < 2 * len / 3; i++) {
            y = 0;
            for (int j = len / 3; j < 2 * len / 3; j++) {
                expandedArray[i][j] = lock[x][y++];
            }
            x++;
        }
        return expandedArray;
    }

    // 배열 회전 (시계방향 90도 회전)
    private int[][] rotateArray(int[][] key) {
        int len = key.length;
        int[][] rotatedKey = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                rotatedKey[i][j] = key[len - 1 - j][i];
            }
        }
        return rotatedKey;
    }

    // 이차원 배열 DeepCopy
    private int[][] implDeepCopy(int[][] lock) {
        int len = lock.length;
        int[][] copiedLock = new int[len][len];
        for (int i = 0; i < len; i++) {
            copiedLock[i] = lock[i].clone();
        }
        return copiedLock;
    }
}
