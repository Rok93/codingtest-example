package practice.kakao2021.intern;

import java.util.HashMap;

public class Problem4 {
    //    public long[] solution(long k, long[] room_number) {
//        int roomNumberLength = room_number.length;
//        long[] answer = new long[roomNumberLength];
//        boolean[] checkIn = new boolean[(int) (k + 1)];
//
//        for (int i = 0; i < roomNumberLength; i++) { // 고객은 투숙하기 원하는 방 번호를 제출합니다.
//            int wantedRoomNumber = (int) room_number[i];
//
//            if (!checkIn[wantedRoomNumber]) { // 3. 고객이 원하는 방이 비어 있다면 즉시 배정합니다.
//                checkIn[wantedRoomNumber] = true;
//                answer[i] = wantedRoomNumber;
//                continue;
//            }
//
//            findEmptyRoom(answer, i, wantedRoomNumber, checkIn);
//            // 4. 고객이 원하는 방이 이미 배정되어 있으면 원하는 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방을 배정합니다.
//        }
//        return answer;
//    }
//
//    private void findEmptyRoom(long[] answer, int index, int wantedRoomNumber, boolean[] checkIn) {
//        for (int i = wantedRoomNumber + 1; i < checkIn.length; i++) {
//            if (!checkIn[i]) {
//                checkIn[i] = true;
//                answer[index] = i;
//                return;
//            }
//        }
//    }
//
    public HashMap<Long, Long> m = new HashMap<Long, Long>();
//
//    public long getParent1(long a) {
//        if(!m.containsKey(a)) {
//            m.put(a, a + 1);
//            return a;
//        } // 경로 압축 X
//        return getParent1(m.get(a));
//    }

    public long getParent2(long a) {
        if (!m.containsKey(a)) {
            m.put(a, a + 1);
            return a;
        }
        m.put(a, getParent2(m.get(a))); // 경로 압축 O
        return m.get(a);
    }

    public long[] solution2(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        for (int i = 0; i < len; i++) {
            long go = room_number[i];

            answer[i] = getParent2(go);
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
