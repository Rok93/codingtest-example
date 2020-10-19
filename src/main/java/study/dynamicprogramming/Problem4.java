package study.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 화폐 종류 (1 <= N <= 100)
        int M = sc.nextInt(); // 가치의 합 (1 <= M <= 10,000)

        int[] moneyPower = new int[N];
        for (int i = 0; i < N; i++) {
            moneyPower[i] = sc.nextInt();
        }

        Arrays.sort(moneyPower);

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] dt = new int[M + 1];
        Arrays.fill(dt, 10001); // 소름.... 배열의 모든 원소를 특정 값으로 채운다는 이런 함수가 있다니..>!?

        // 불가능 할 때는 -1을 출력한다.
        dt[0] = 0;
        for (int i = 0; i < N; i++) {
            int k = moneyPower[i];
            for (int j = k; j <= M; j++) {
                // 현재 선택한 화폐 단위가 k라고 했을 때
                // (j - k)원을 만드는 방법이 존재하는 경우 (시작을 moneyPower[i] 부터 시작! 처음 index가 0 이 되게 만들어야 하기 때문이다!)
                if (dt[j - k] != 10001) {
                    dt[j] = Math.min(dt[j], dt[j - k] + 1);
                }
            }
        }

        // 계산된 결과 출력
        if (dt[M] == 10001) {
            System.out.println(-1);
            return;
        }

        System.out.println(dt[M]);
    }
}
