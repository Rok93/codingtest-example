package monthlycodingtest;

import java.math.BigInteger;

public class Problem1 {

    public int solution(int[] absolutes, boolean[] signs) {
        BigInteger sum = BigInteger.ZERO;
        int length = absolutes.length;

        for (int i = 0; i < length; i++) {
            sum = operate(sum,  absolutes[i], signs[i]);
        }

        return sum.intValue();
    }

    private BigInteger operate(BigInteger sum, int absolute, boolean sign) {
        if (sign) {
            return sum.add(BigInteger.valueOf(absolute));
        }

        return sum.subtract(BigInteger.valueOf(absolute));
    }
}
