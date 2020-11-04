package wootech1st20201101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    private static final String REQUEST = "request";
    private static final String LEAVE = "leave";

    public String[] solution(int totalTicket, String[] logs) {
        // log : (id, action[request/leave], 시분초 hh:mm:ss)

        List<String> list = new ArrayList<>();
        String endTime = "";
        for (String log : logs) {
            String[] infos = log.split(" ");
            String id = infos[0];
            String action = infos[1];
            String time = infos[2];

            if (action.equals(REQUEST)) {
                if (list.isEmpty()) {
                    list.add(id);
                    endTime = getLastOneMinute(time);
                    continue;
                }

                if (isPossibleReservation(time, endTime)) {
                    list.add(id);
                    endTime = getLastOneMinute(time);
                }

                continue;
            }

            if (action.equals(LEAVE)) {
                list.remove(id);
                endTime = time;
                continue;
            }


        }

        return list.stream()
                .limit(totalTicket)
                .sorted()
                .toArray(String[]::new);
    }

    private boolean isPossibleReservation(String time, String endTime) {
        int[] reservationTimes = getTimes(time);
        int[] endTimes = getTimes(endTime);

        if (reservationTimes[1] - endTimes[1] >= 2) {
            return true;
        }

        if (reservationTimes[1] - endTimes[1] < 1) {
            return false;
        }

        return reservationTimes[2] - endTimes[2] >= 0;
    }

    private String getLastOneMinute(String time) {
        int[] times = getTimes(time);

        times[1]++; // 1분 추가!

        if (times[1] >= 60) {
            times[1] -= 60;
            times[0]++;
        }

        return times[0] + ":" + times[1] + ":" + times[2];
    }

    private int[] getTimes(String time) {
        return Arrays.stream(time.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
