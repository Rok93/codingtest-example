package wootech1st20201101;

public class Problem1 {
    private static final int[] MONEY_UNITS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public int[] solution(int money) {
        int[] answer = new int[MONEY_UNITS.length];
        int cnt = 0;
        for (int moneyUnit : MONEY_UNITS) {
            answer[cnt++] = money / moneyUnit;
            money %= moneyUnit;
        }

        return answer;
    }
}
