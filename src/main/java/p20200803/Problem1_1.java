package p20200803;

import java.util.Arrays;

// 프로그래머스 고득점Kit --> 입국 심사
public class Problem1_1 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binerySearch(n, times);
    }

    private long binerySearch(int n, int[] times) {
        long maxTime = (long) times[times.length - 1] * n;

        long pl = 1;
        long pr = maxTime; //최대 시간!
        long answer = Long.MAX_VALUE;
        long pc = 0;

        while (pl <= pr) {
            pc = (pl + pr) / 2;

            if (isCollect(times, n, pc)) {
                answer = answer > pc ? pc : answer;
                pr = pc - 1;
                continue;
            }
            pl = pc + 1;
        }
        return answer;
    }

    private boolean isCollect(int[] times, int n, long mid) {
        long judgedPeopleNumber = Arrays.stream(times)
                .boxed()
                .mapToLong(time -> mid / time)
                .sum();
        return judgedPeopleNumber >= n;
    }
}
