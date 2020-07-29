package p20200710;

import java.util.*;
import java.util.stream.*;

public class TestProblem {
    private int cnt = 0;

    public int solution(int n) {
        Scanner sc = new Scanner(System.in);
        dfs(0, n, 1);
        return cnt;
    }

    private void dfs(int sum, int targetNumber, int currentNumber) {
        if (sum > targetNumber || currentNumber > targetNumber) {
            return;
        }

        if (sum == targetNumber) {
            cnt++;
            return;
        }

        dfs(sum + currentNumber, targetNumber, currentNumber + 1);
        dfs(sum, targetNumber, currentNumber + 1);
    }
}
