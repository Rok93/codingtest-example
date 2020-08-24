package p20200823.socar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SocarProblem1 {
    public int solution(String[] bakery_schedule, String current_time, int K) {
        List<Task> tasks = Arrays.stream(bakery_schedule)
                .map(Task::new)
                .collect(Collectors.toList());

        int bakerySum = 0;
        int afterTime = 0;
        for (Task task : tasks) {
            if (!task.afterThat(current_time)) {
                continue;
            }

            bakerySum += task.getBakery();
            afterTime += task.calculateTimeGap(current_time);

            current_time = task.getTime();

            if (bakerySum >= K) {
                return afterTime;
            }
        }

        return -1;
    }

    public class Task {
        private static final int ONE_HOUR_MINUTES = 60;

        private final String time;
        private final int bakery;

        public Task(String schedule) {
            String[] splitSchedule = schedule.split(" ");
            this.time = splitSchedule[0];
            this.bakery = Integer.parseInt(splitSchedule[1]);
        }

        public String getTime() {
            return time;
        }

        public boolean afterThat(String time) { // 지금 task가 time 보다 뒤의 일인가!
            return this.time.compareTo(time) >= 0 ? true : false;
        }

        public int getBakery() {
            return bakery;
        }

        public int calculateTimeGap(String current_time) {
            String[] currentTimes = current_time.split(":");
            String[] taskTimes = this.time.split(":");

            int currentHour = Integer.parseInt(currentTimes[0]);
            int currentMin = Integer.parseInt(currentTimes[1]);
            int taskTimeHour = Integer.parseInt(taskTimes[0]);
            int taskTimeMin = Integer.parseInt(taskTimes[1]);

            int hourGap = taskTimeHour - currentHour;
            int minGap = taskTimeMin - currentMin;

            return hourGap * ONE_HOUR_MINUTES + minGap;
        }
    }
}
