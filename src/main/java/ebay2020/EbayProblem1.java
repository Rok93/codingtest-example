package ebay2020;

import java.util.PriorityQueue;

public class EbayProblem1 {
    public int solution(int N, int[][] simulation_data) { // N : 상담 창구 개수, [대기번호, 상담 시간] simulation_data
        int answer = 0;
        PriorityQueue<Guest> queue = new PriorityQueue<>();
        for (int[] simulation : simulation_data) {
            int time = simulation[0]; // 시간

            for (int i = 0; i < queue.size(); i++) {
                if (queue.peek().getDiscussEndTime() < time) {
                    queue.poll();
                }
            }

            int discussTime = simulation[1]; // 상담시간

            if (queue.size() < N) {
                queue.offer(new Guest(time, discussTime));
                continue;
            }

            int endTime = queue.poll().getDiscussEndTime();
            System.out.println(endTime);
            int delayTime = endTime - time;
            System.out.println(delayTime);
            answer += delayTime;
            queue.offer(new Guest(time + delayTime, discussTime));
        }

        //answer -> 고객들이 대기 번호를 받은 후 창구에 배정되기까지 기다린 시간의 총합을 return 하도록 solution 함수를 완성해주세요.
        return answer;
    }

    public class Guest implements Comparable<Guest> {
        private final int time;
        private final int discussTime;

        public Guest(int time, int discussTime) {
            this.time = time;
            this.discussTime = discussTime;
        }

        public int getDiscussEndTime() {
            return time + discussTime;
        }

        @Override
        public int compareTo(Guest o) {
            return getDiscussEndTime() - o.getDiscussEndTime();
        }
    }
}
