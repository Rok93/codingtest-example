package coupang;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

//리팩토링 거치기

public class Problem1 {
    public int[] solution(int n, int min_position, int max_position, int[] positions) {
        int gap = (int) ((max_position - min_position) / (n - 1)); //집과 집사이 거리
        List<Integer> homeList = new ArrayList<>();
        List<Integer> positionsList = new ArrayList<>();

        for (int i : positions) {
            positionsList.add(i);
        }
        //모든 집리스트 저장
        for (int i = min_position; i <= max_position; i += gap) {
            homeList.add(i);
        }

        List<Integer> answerList = homeList.stream()
                .filter(a -> !positionsList.contains(a))
                .collect(toList());

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
