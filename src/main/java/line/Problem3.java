package line;

import java.util.Arrays;

public class Problem3 {
    public int solution(String road, int n) {
        int answer = -1;

        String[] roads = road.split("");
        int numberOfBadConditionRoad = (int) Arrays.stream(roads)
                .filter(r -> r.equals("0"))
                .count();
        if (numberOfBadConditionRoad == 0 || numberOfBadConditionRoad <= n) {
            return road.length(); //손상된 부분이 없거나, 보수 가능 횟수 > 손상된 부분 이면 주어진 도로의 길이가 최대 정상 길이
        }


        return answer;
    }

    public static void main(String[] args) {

    }
}
