package coupang2020;

import java.util.PriorityQueue;

public class CoupangProblem2 {
    private final static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public class Kiosk implements Comparable<Kiosk> {
        private final int id;
        private String startTime = "";
        private String endTime = "00/00 00:00:00";
        private int peopleNumber = 0;

        public Kiosk(int id) {
            this.id = id;
        }

        public void takeChargeOfCustomer(String customer) {
            peopleNumber++;
            String[] timeInfo = customer.split(" ");
            String startTime = timeInfo[0] + " " + timeInfo[1];
            int consumeTime = Integer.parseInt(timeInfo[2]); // 분단위!

            if (startTime.isEmpty()) {
                this.startTime = startTime;
                calculateEndTime(consumeTime); // endTime도 정해진다!
                return;
            }

            //startTime이 비어있지 않다면 계산이 필요함!
            int[] thisEndStatus = timeStatus(endTime);
            int[] customerStartStatus = timeStatus(startTime);

            for (int i = 0; i < 5; i++) {
                if (thisEndStatus[i] < customerStartStatus[i]) {
                    this.startTime = startTime;
                    calculateEndTime(consumeTime);
                    return;
                }

                if (thisEndStatus[i] > customerStartStatus[i]) {
                    this.startTime = endTime;
                    calculateEndTime(consumeTime); // end시간 부터 시작!
                    return;
                }
            }

            this.startTime = endTime;
            calculateEndTime(consumeTime);
        }

        private void calculateEndTime(int consumeTime) {
            int[] endTimeStatus = timeStatus(startTime);
            endTimeStatus[3] += consumeTime;

            if (endTimeStatus[3] >= 60) {
                endTimeStatus[3] -= 60;

                endTimeStatus[2]++;
                if (endTimeStatus[2] >= 24) {
                    endTimeStatus[2] = 0;

                    endTimeStatus[1]++;
                    if (endTimeStatus[1] > days[endTimeStatus[0]]) {
                        endTimeStatus[1] = 1;

                        endTimeStatus[0]++;
                        if (endTimeStatus[0] > 12) {
                            endTimeStatus[0] = 1;
                        }
                    }
                }
            }

            endTime = composeEndTime(endTimeStatus);
        }

        private String composeEndTime(int[] timeStatus) {
            return timeStatus[0] + "/" + timeStatus[1] + " " + timeStatus[2] + ":"
                    + timeStatus[3] + ":" + timeStatus[4];
        }

        public int getId() {
            return id;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public int getPeopleNumber() {
            return peopleNumber;
        }

        @Override
        public int compareTo(Kiosk o) {
            int[] thisTimeStatus = timeStatus(endTime);
            int[] otherTimeStatus = timeStatus(o.endTime);

            for (int i = 0; i < 5; i++) {
                if (thisTimeStatus[i] < otherTimeStatus[i]) {
                    return -1;
                }

                if (thisTimeStatus[i] > otherTimeStatus[i]) {
                    return 1;
                }
            }

            if (id < o.id) {
                return -1;
            }

            return 1;
        }

        private int[] timeStatus(String customer) {
            String[] status = customer.split(" ");

            String[] dateTime = status[0].split("/");
            int month = Integer.parseInt(dateTime[0]);
            int day = Integer.parseInt(dateTime[1]);

            String[] times = status[1].split(":");
            int hour = Integer.parseInt(times[0]);
            int minute = Integer.parseInt(times[1]);
            int second = Integer.parseInt(times[2]);

            return new int[]{month, day, hour, minute, second};
        }
    }

    public int solution(int n, String[] customers) {
        // 고객이 점포에 도착한 후 번호표를 뽑으면, 업무처리를 도와줄 키오스크를 매칭받을 수 있습니다.

        //점포에 설치되어 있는 키오스크 n대는 1부터 n번까지 고유번호가 매겨져 있으며,
        // 고객은 아래와 같은 규칙으로 키오스크와 매칭됩니다.
        // 1. 고객이 점포에 도착한 시간 순으로 키오스크와 매칭
        // 2. 현재 운영되지 않는 키오스크가 있다면, 고객들의 업무를 완료한 후 현재 시각까지 운영되지 않은 시간이
        // 가장 긴 키오스크와 매칭된다.
        // 2-1. 운영되지 않은 시간이 가장 긴 키오스크가 여러 대라면, 그 중에서 고유번호가 낮은 키오스크와 매칭된다.
        // 2-2. 고객은 점포에 도착하자마자 매칭된 키오스크와 업무를 시작할 수 있다.
        // 3. 모든 키오스크가 운영되고 있다면, 고객은 가장 일찍 운영이 종료될 예정인 키오스크와 매칭된다.
        // 3-1. 가장 일찍 운영디 종료될 키오스크가 여러 대라면, 그 중에서 고유번호가 가장 낮은 키오스크와 매칭된다.
        // 3-2. 키오스크는 먼저 매칭된 고객들의 업무부터 차례대로 처리한다.

        // customers의 원소는 "도착날짜 도착시간 소요시간" 형식입니다.
        // 도착날짜, 도착시간, 소요시간은 하나의 공백으로 구분

        // 도착 날짜 -> MM/DD 형식
        // 윤년은 존재X로 가정 (2월은 항상 28일)
        // 도착시간은 HH:MM:SS 형식, 00:00:00 에서 23:59:59 사이이다.
        // 소요시간은 고객의 업무를 처리하는데 소요되는 시간(분)이다.
        // 소요시간은 MM형식이며, 01에서 59 사이이다. (고객 소요시간은 01분 ~ 59분)

        // 가장 많은 고객과 매칭되는 키오스크는 몇 명의 고객과 매칭되는지 계산해서 return 하라!

        PriorityQueue<Kiosk> kiosks = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            kiosks.offer(new Kiosk(i));
        }

        for (String customer : customers) {
            Kiosk now = kiosks.poll();
            now.takeChargeOfCustomer(customer);
            kiosks.offer(now);
        }

        int asInt = kiosks.stream()
                .mapToInt(Kiosk::getPeopleNumber)
                .max()
                .getAsInt();

        return asInt;
    }
}
