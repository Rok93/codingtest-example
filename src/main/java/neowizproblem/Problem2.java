package neowizproblem;

public class Problem2 {
    public int solution(int[] s) {
        boolean[] increaseAndDecrease = getIncreaseAndDecrease(s); //증감 추이!
        return countMismatching(increaseAndDecrease);
    }

    private boolean[] getIncreaseAndDecrease(int[] s) {
        int len = s.length;
        boolean[] incANdDec = new boolean[len - 1];
        for (int i = 0; i < len - 1; i++) {
            int beforeNum = s[i];
            int currentNum = s[i + 1];
            incANdDec[i] = (currentNum - beforeNum > 0) ? true : false;
        }
        return incANdDec;
    }

    private int countMismatching(boolean[] increaseAndDecrease) {
        int cnt = 0;
        if (increaseAndDecrease[0] == false) { //예외
            cnt++;
        }

        int len = increaseAndDecrease.length;
        for (int i = 0; i < len - 1; i++) {
            boolean before = increaseAndDecrease[i];
            boolean current = increaseAndDecrease[i + 1];
            if (before == current) {
                cnt++;
            }
        }
        return cnt;
    }
}
