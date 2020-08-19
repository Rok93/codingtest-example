package woo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    private final List<String> buyer = new ArrayList<>();
    private String endOfActionTime = "09:00:00";

    public String[] solution(int totalTicket, String[] logs) {
        for (String log : logs) {
            String[] splitLog = log.split(" ");
            String user = splitLog[0];
            String action = splitLog[1];
            String time = splitLog[2];

            action(user, action, time);
        }

        return buyer.stream()
                .limit(totalTicket)
                .sorted()
                .toArray(String[]::new);
    }

    private void action(String user, String action, String time) {
        if (action.equals("leave")) {
            endOfActionTime = time; // 조기 로그아웃
            buyer.remove(user);
            return;
        }

        if (isOverThanEndOfActionTime(time)) {
            buyer.add(user);
            endOfActionTime = calculateEndOfActionTime(time);
        }
    }

    private String calculateEndOfActionTime(String time) {
        String[] times = time.split(":");
        int minutes = Integer.parseInt(times[1]);
        int seconds = Integer.parseInt(times[2]);

        return times[0] + ":" + (minutes + 1) + ":" + seconds;
    }

    private boolean isOverThanEndOfActionTime(String time) {
        int[] times = Arrays.stream(time.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] endOfActionTimes = Arrays.stream(endOfActionTime.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        //시간 대조는 할 필요 없음
        int minutesGap = times[1] - endOfActionTimes[1];
        int secondsGap = times[2] - endOfActionTimes[2];
        if (minutesGap >= 2 || (minutesGap == 1 && secondsGap >= 0)) {
            return true;
        }

        return false;
    }
}
