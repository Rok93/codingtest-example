package onlinestudy.week1;

import java.util.LinkedList;
import java.util.Queue;

// 문자열 압축
public class KakaoProblem1 {
    public int solution(String s) {
        if (s.length() <= 2) {
            return s.length();
        }

        int answer = Integer.MAX_VALUE;

        int length = s.length();
        for (int i = 1; i <= length / 2; i++) { // i = 자릿 수
            Queue<String> queue = new LinkedList<>();
            int loopCnt = length / i + 1;
            for (int j = 0; j < loopCnt; j++) {
                if ((j + 1) * i > length) {
                    queue.offer(s.substring(j * i));
                    continue;
                }

                queue.offer(s.substring(j * i, (j + 1) * i));
            }


            int sum = 0;
            String currentStr = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty()) {
                String nextStr = queue.poll();
                if (currentStr.equals(nextStr)) {
                    cnt++;
                    continue;
                }

                if (cnt > 1) {
                    sum += String.valueOf(cnt).length() + currentStr.length();
                    currentStr = nextStr;
                    cnt = 1;
                    continue;
                }

                sum += currentStr.length();
                currentStr = nextStr;
                cnt = 1;
            }

            if (cnt > 1) {
                sum += String.valueOf(cnt).length() + currentStr.trim().length();
            } else {
                sum += currentStr.trim().length();
            }

            answer = answer > sum ? sum : answer;
        }
        return answer;
    }
}
