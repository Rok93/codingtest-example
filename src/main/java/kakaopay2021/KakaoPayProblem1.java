package kakaopay2021;

import java.math.BigInteger;

public class KakaoPayProblem1 {

    private static final int THROW_OUT_MONEY = 100;

    // 모든 시민에 대해 해당 시민이 소유하는 금액을 매달 말에 징수하는 정책
    // 정책에 쓰이는 파라미터 --> minratio, maxratio, ranksize, threshold 4가지
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold,
        int months) {

        int ownAssumeMoney;
        for (int month = 1; month <= months; month++) {
            ownAssumeMoney = money;
            ownAssumeMoney -= (ownAssumeMoney % THROW_OUT_MONEY);

            if (threshold > ownAssumeMoney) {
                break;
            }

            int ceil = (int) Math.ceil((ownAssumeMoney - threshold) / ranksize);
            int finalRatio = (minratio + ceil);

            if (finalRatio > maxratio) {
                finalRatio = maxratio;
            }

            int tax = BigInteger.valueOf(finalRatio).multiply(BigInteger.valueOf(ownAssumeMoney))
                .divide(BigInteger.valueOf(100)).intValue();
            money -= tax;
        }

        return money;
    }

}
