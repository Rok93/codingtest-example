package onlinestudy.week1;

import java.util.ArrayList;
import java.util.List;

public class KakaoProblem3 {
    private static final int COLUMN = 0;  // 3번째 요소
    private static final int ROW = 1; // 보
    private static final int DELETE = 0;
    private static final int SETUP = 1;
    private int[][] constructed;
    private int n;
    private boolean[][] columnSpace;

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        constructed = new int[n + 1][n + 1];
        columnSpace = new boolean[n + 1][n + 1];

        for (int[] build : build_frame) {
            int y = build[0];
            int x = build[1];
            int kind = build[2];
            int deleteOrSetUp = build[3];

            if (deleteOrSetUp == SETUP) { // 설치하는 경우
                if (x == 0) { // 바닥의 경우!
                    if (kind == ROW) { // 바닥에서 보 설치는 무시된다.
                        continue;
                    }

                    // 기둥 설치
                    columnSpace[x + 1][y] = true;
                    constructed[x][y]++;
                    constructed[x + 1][y]++;
                    continue;
                }

                if (kind == ROW) { // 보 설치
                    if (y + 1 > n && isNotSetUp(x, y)) { // 값을 초과하면 무시한다
                        continue;
                    }

                    constructed[x][y]++;
                    constructed[x][y + 1]++;
                    continue;
                }
                // 기둥 설치
                if (x + 1 > n) { // 값을 초과하거나, 기둥위가 아니거나  보 끝이 아닌 경우 기둥을 세우는 경우는 무시한다!
                    continue;
                }

                if (columnSpace[x][y] || constructed[x][y] == 1) {
                    constructed[x][y]++;
                    constructed[x + 1][y]++;
                    columnSpace[x + 1][y] = true;
                    continue;
                }
                continue;
            }

            if (deleteOrSetUp == DELETE) { // 삭제한다
                if (kind == ROW) { // 보를 삭제하는 경우
                    if (isNotDelete(x, y, kind)) { // 삭제가 불가능한 보 혹은 기둥이면 무시한다
                        continue;
                    }

                    constructed[x][y]--;
                    constructed[x][y + 1]--;
                    continue;
                }

                // 기둥을 삭제하는 경우!
                if (isNotDelete(x, y, kind) && constructed[x + 1][y] >= 2) { // 기둥이 아니거나, 삭제 불가능하다면! 무시!
                    continue;
                }

                columnSpace[x + 1][y] = false;
                constructed[x][y]--;
                constructed[x + 1][y]--;
            }
        }

        List<int[]> answerList = new ArrayList<>();
        for (int j = 0; j < n + 1; j++) {
            for (int i = 0; i < n; i++) {
                while (constructed[i][j] > 0) {

                    // 보 추가!
                    if (i + 1 <= n && columnSpace[i + 1][j]) { // 기둥 : 0, 보 : 1
                        answerList.add(new int[]{j, i, COLUMN});
                        constructed[i][j]--;
                        constructed[i + 1][j]--;
                        columnSpace[i][j] = false;
                        continue;
                    }

                    answerList.add(new int[]{j, i, ROW});
                    constructed[i][j]--;
                    constructed[i][j + 1]--;
                }
            }
        }

        return answerList.stream().toArray(int[][]::new);
    }

    private boolean isNotSetUp(int x, int y) {
        if (columnSpace[x][y] || constructed[x][y] >= 1 || constructed[x + 1][y + 1] >= 1) {
            return true;
        }
        return false;
    }

    private boolean isNotDelete(int x, int y, int kind) {
        int currentConstructed = constructed[x][y] - 1;

        if (kind == ROW) { // 삭제하는게 '보'라면 !
            int connectedConstructed = constructed[x][y + 1] - 1;
            if (currentConstructed <= 1 && connectedConstructed <= 1) { // 삭제 불가능하고!
                return true;
            }
            return false;
        }

        // 삭제하는게 기둥이라면 !
        int connectedConstructed = constructed[x + 1][y] - 1;
        if (currentConstructed <= 1 && connectedConstructed <= 1 || !columnSpace[x + 1][y]) { // 삭제 불가능하고!
            return true;
        }
        return false;
    }
}
