package coupang;

import java.util.Arrays;
import java.util.List;

public class Problem2 {
    private int continueDay;
    private int maxSum;
    private int maxValue;

    static int[] set;
    static int answer = 0;

    public int solution(int N, int M, int T, int K) { //총 N일, 총 M개, 연속된 T일, 합이 K개
        continueDay = T;
        maxSum = K;
        maxValue = M;
        set = new int[N];

        nPir(0);

        return answer;
    }

    public void nPir(int len) {// 중복순열
        if (len == set.length) {

            if (Arrays.stream(set).sum() == maxValue && isSatisfiedTdaysSum(set)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i <= maxSum; i++) {
            set[len] = i;
            nPir(len + 1);
        }
    }

    private boolean isSatisfiedTdaysSum(int[] temp) {
        for (int i = 0; i < (temp.length - (continueDay - 1)); i++) {
            if (!sumTdays(temp, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean sumTdays(int[] temp, int currentIndex) {
        int[] part = Arrays.copyOfRange(temp, currentIndex, currentIndex + (continueDay));

        if (Arrays.stream(part).sum() > maxSum) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        int N1 = 2;
        int M1 = 4;
        int T1 = 1;
        int K1 = 3;
//        System.out.println("1번정답: " + sol.solution(N1, M1, T1, K1)); // 3

        int N2 = 4;
        int M2 = 7;
        int T2 = 2;
        int K2 = 4;
//        System.out.println("2번정답: " + sol.solution(N2, M2, T2, K2)); // 28

        int N3 = 4;
        int M3 = 7;
        int T3 = 2;
        int K3 = 3;
        System.out.println("3번정답: " + sol.solution(N3, M3, T3, K3)); // 0


    }
}
