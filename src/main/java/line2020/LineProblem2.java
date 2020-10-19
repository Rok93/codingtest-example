package line2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineProblem2 {

    private List<Integer> balls;
    private List<Integer> answer;
    private List<Integer> keepBalls;

    public int[] solution(int[] ball, int[] order) {

        // 왼쪽 또는 오른쪽으로만 빠져나갈 수 있는 원통형 파이프 안에 숫자가 쓰인 공이 일렬로 들어있다. 명령에 따라 공을 하나씩 뺼 때, 공이 빠져나오는 순서
        balls = Arrays.stream(ball)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        answer = new ArrayList<>();
        keepBalls = new ArrayList<>();


        for (int orderNumber : order) {
            if (balls.get(0).equals(orderNumber)) {
                balls.remove(0);
                answer.add(orderNumber);
                keepBallFind();
                continue;
            }

            if (balls.get(balls.size() - 1).equals(orderNumber)) {
                balls.remove(balls.size() - 1);
                answer.add(orderNumber);
                keepBallFind();
                continue;
            }

            keepBalls.add(orderNumber);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void keepBallFind() {
        while (!balls.isEmpty() && keepBalls.contains(balls.get(0))) {
            answer.add(balls.get(0));
            keepBalls.remove(new Integer(balls.get(0)));
            balls.remove(0);
        }

        while (!balls.isEmpty() && keepBalls.contains(balls.get(balls.size() - 1))) {
            answer.add(balls.get(balls.size() - 1));
            keepBalls.remove(new Integer(balls.get(balls.size() - 1)));
            balls.remove(balls.size() - 1);
        }
    }
}
