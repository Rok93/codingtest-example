package study.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 외벽 점검
public class ActualProblem6 {
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;

        int maxValue = Arrays.stream(weak)
                .map(number -> Math.abs(number - (n / 2)))
                .max()
                .getAsInt();

        int minValue = Arrays.stream(weak)
                .map(number -> Math.abs(number - (n / 2)))
                .min()
                .getAsInt();

        int gap = maxValue - minValue;

        List<Integer> friends = Arrays.stream(dist)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());


        boolean existPossibleFriend = friends.stream()
                .anyMatch(friend -> friend >= gap);


        if (existPossibleFriend) { // 올 커버 가능한 사람 있다면 그놈 한명이 처리 가능!
            return 1;
        }


        Arrays.sort(dist);

        int length = weak.length;
        for (int i = 0; i <= n / 2; i++) {
            int finalI = i;
            List<Integer> weaks = Arrays.stream(weak)
                    .mapToObj(number -> getNumber(number, finalI, n))
                    .collect(Collectors.toList());

            System.out.println(weaks);
        }


        // 외벽의 길이 n, 취약 지점의 위치가 담긴 배열 weak, 각 친구가 1시간 동안 이동할 수 있는 거리가 담긴 배열 dist


        // 취약 지점을 점검하기 위해 보내야 하는 친구 수의 최소값을 return 하도록 solution 함수 작성
        // 친구들을 모두 투입해도 취약 지점을 점검할 수 없는 경우에는 -1을 return

        return answer;
    }

    private int getNumber(int number, int i, int n) {
        int currentNumber = number - i;
        return currentNumber <= (n / 2) ? currentNumber : currentNumber - n;
    }
}
