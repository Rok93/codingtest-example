package kakao2020;

import java.util.PriorityQueue;

public class KakaoProblem5 {
    public String solution(String play_time, String adv_time, String[] logs) {

        //죠르디는 시청자들이 해당 동영상의 어떤 구간을 재생했는 지 알 수 있는 재생구간 기록을 구했고,
        // 해당 기록을 바탕으로 공익광고가 삽입될 최적의 위치를 고를 수 있었습니다.
        // 참고로 광고는 재생 중인 동영상의 오른쪽 아래에서 원래 영상과 동시에 재생되는 PIP(Picture in Picture) 형태로 제공됩니다.

        String answer = "";

        //play_time : 총 동영상 재생 시간 : 00:00:01 이상 99:59:59 이하
        // adv_time : 총 공익광고 재생 시간 : 00시간 00분 1초 이상   99시간 59분 59초 이하
        // play_time >= adv_time  조건

        //logs : 1 ~ 300,000 이하인 문자열 배열이다.
        // logs의 각 원소는 H1:M1:S1-H2:M2:S2 형식 --> H1:M1:S1은 동영상 시작 시간 H2:M2:S2는 동영상 종료 시각

        // 시간은 00 ~ 99,  분, 초는 00 ~ 59 까지


//        PriorityQueue<UserPlay> userPlays = new PriorityQueue<>();
        PriorityQueue<Integer> starts = new PriorityQueue<>();
        PriorityQueue<Integer> ends = new PriorityQueue<>();

        for (String log : logs) {
            String[] infos = log.split("-");
            starts.offer(changeTime(infos[0]));
            ends.offer(changeTime(infos[1]));
        }

        while (!starts.isEmpty() || !ends.isEmpty()) {
            int currentTime;
            if (starts.peek() > ends.peek()) {
                currentTime = starts.poll();
            } else {
                currentTime = ends.poll();
            }


        }

        return answer;
    }

    private int changeTime(String log) {
        String[] times = log.split(":");
        return Integer.parseInt(times[0] + times[1] + times[2]);
    }

    public class UserPlay implements Comparable<UserPlay> {
        private final int start;
        private final int end;

        public UserPlay(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(UserPlay o) {
            if (end < o.end) {
                return -1;
            }

            return 1;
        }
    }
}
