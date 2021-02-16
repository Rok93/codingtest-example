package wootech3rd;

public class WooProblem3 {
    private static final int NEXT_MULTIPLE_NUMBER = 2;
    private static final int INITIAL_BATTING_MONEY = 100;

    public int solution(int money, String[] expected, String[] actual) {

        int currentMoney = INITIAL_BATTING_MONEY;

        int length = expected.length;

        for (int i = 0; i < length; i++) {
            if (!expected[i].equals(actual[i])) {
                money -= currentMoney;
                currentMoney *= NEXT_MULTIPLE_NUMBER;

                if (money < currentMoney) {
                    currentMoney = money;
                }
                continue;
            }

            // 이기면!
            money += currentMoney;
            currentMoney = INITIAL_BATTING_MONEY;
        }

        return money;
    }
}
