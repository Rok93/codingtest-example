package programmers.level2test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은
두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 */
public class Problem2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        List<Integer> foodList = new ArrayList<>();
        for (int foodValue : scoville) {
            foodList.add(foodValue);
        }

        while (underScovilleExist(K, foodList)) {
            if (foodList.size() < 2) {
                return -1;
            }

            answer++;
            foodList.sort(Comparator.comparing(Integer::intValue)); //오름차순으로 정렬

            int newFood = mixFood(foodList.get(0), foodList.get(1));

            foodList.remove(1);
            foodList.set(0, newFood);
        }

        return answer;
    }

    private boolean underScovilleExist(int K, List<Integer> foodList) {
        return foodList.parallelStream()
                .anyMatch(n -> n < K);
    }

    public int mixFood(int firstFood, int secondFood) {
        return (firstFood + (2 * secondFood));
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        Problem2 sol = new Problem2();
        System.out.println(sol.solution(scoville, K));
    }
}
