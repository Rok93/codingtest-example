package p20200803;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 프로그래머스 고득점Kit --> 입국 심사
public class Problem1 {
    public long solution(int n, int[] times) {
        List<Judge> judges = Arrays.stream(times)
                .boxed()
                .map(Judge::new)
                .collect(Collectors.toList());

        int time;
        for (time = 1; ; time++) {
            if (countJudgedPeoples(judges, time) == n) {
                return time;
            }
        }
    }

    private int countJudgedPeoples(List<Judge> judges, int i) {
        return judges.stream()
                .mapToInt(judge -> judge.getJudgedPeopleNumber(i))
                .sum();
    }

    public class Judge {
        private final int equality; //일률

        public Judge(int equality) {
            this.equality = equality;
        }

        public int getJudgedPeopleNumber(int currentTime) {
            return currentTime / equality;
        }
    }
}
