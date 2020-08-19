package woo1;

public class Problem1 {
    private static final int[] MONEY_UNIT = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public int[] solution(int money) {
        int[] answer = new int[MONEY_UNIT.length];

        int length = MONEY_UNIT.length;
        for (int i = 0; i < length; i++) {
            answer[i] = money / MONEY_UNIT[i];
            money %= MONEY_UNIT[i];
        }

        return answer;
    }
}
